import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class SimpleGameApplication {

    // Define the size of the game grid
    public static final int GRID_SIZE = 10;
    public static int[][] gameGrid = new int[GRID_SIZE][GRID_SIZE];

    // Player's position initially at top-left corner
    public static int[] playerPosition = {0, 0};

    // Player's score
    public static int score = 0;

    // List to keep track of enemy positions
    public static ArrayList<int[]> enemies = new ArrayList<>();

    // Item character in the grid
    public static final int ITEM = 2;

    // Enemy character in the grid
    public static final int ENEMY = 3;

    public static void main(String[] args) {
        // Initialize game with some items and enemies
        placeItems(5);
        spawnEnemies(3);

        // Run the game loop
        runGame();
    }

    // Method to move the player in the specified direction
    public static void movePlayer(char direction) {
        int x = playerPosition[0];
        int y = playerPosition[1];
        switch (direction) {
            case 'w': // move up
                if (x > 0) playerPosition[0]--;
                break;
            case 's': // move down
                if (x < GRID_SIZE - 1) playerPosition[0]++;
                break;
            case 'a': // move left
                if (y > 0) playerPosition[1]--;
                break;
            case 'd': // move right
                if (y < GRID_SIZE - 1) playerPosition[1]++;
                break;
            default:
                System.out.println("Invalid move!");
        }
        collectItem();
    }

    // Method to place items randomly on the grid
    public static void placeItems(int count) {
        Random rand = new Random();
        for (int i = 0; i < count; i++) {
            int x, y;
            do {
                x = rand.nextInt(GRID_SIZE);
                y = rand.nextInt(GRID_SIZE);
            } while (gameGrid[x][y] != 0);
            gameGrid[x][y] = ITEM;
        }
    }

    // Method to collect item and update score
    public static void collectItem() {
        int x = playerPosition[0];
        int y = playerPosition[1];
        if (gameGrid[x][y] == ITEM) {
            score += 10; // each item increases score by 10
            System.out.println("Item collected! Score: " + score);
            gameGrid[x][y] = 0; // remove item from grid
        }
    }

    // Method to spawn enemies at random positions
    public static void spawnEnemies(int count) {
        Random rand = new Random();
        for (int i = 0; i < count; i++) {
            int[] enemyPos = new int[2];
            do {
                enemyPos[0] = rand.nextInt(GRID_SIZE);
                enemyPos[1] = rand.nextInt(GRID_SIZE);
            } while (gameGrid[enemyPos[0]][enemyPos[1]] != 0 || (enemyPos[0] == playerPosition[0] && enemyPos[1] == playerPosition[1]));
            enemies.add(enemyPos);
            gameGrid[enemyPos[0]][enemyPos[1]] = ENEMY;
        }
    }

    // Method to update enemies. Move randomly in the grid
    public static void updateEnemies() {
        Random rand = new Random();
        for (int[] enemy : enemies) {
            int x = enemy[0];
            int y = enemy[1];
            gameGrid[x][y] = 0; // Clear current position
            int direction = rand.nextInt(4);
            switch (direction) {
                case 0: if (x > 0) enemy[0]--; break; // move up
                case 1: if (x < GRID_SIZE - 1) enemy[0]++; break; // move down
                case 2: if (y > 0) enemy[1]--; break; // move left
                case 3: if (y < GRID_SIZE - 1) enemy[1]++; break; // move right
            }
            // Place enemy in new position
            gameGrid[enemy[0]][enemy[1]] = ENEMY;
        }
        checkCollisions();
    }

    // Check for collisions between player and enemies
    public static void checkCollisions() {
        int px = playerPosition[0];
        int py = playerPosition[1];
        for (int[] enemy : enemies) {
            if (enemy[0] == px && enemy[1] == py) {
                System.out.println("Game Over! You collided with an enemy.");
                System.exit(0);
            }
        }
    }

    // Run the game loop
    public static void runGame() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printGrid();
            System.out.println("Move (w/a/s/d): ");
            char move = scanner.next().charAt(0);
            movePlayer(move);
            updateEnemies();
        }
    }

    // Print the current state of the grid
    public static void printGrid() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (i == playerPosition[0] && j == playerPosition[1]) {
                    System.out.print('P'); // Player position
                } else if (gameGrid[i][j] == ITEM) {
                    System.out.print('I'); // Item position
                } else if (gameGrid[i][j] == ENEMY) {
                    System.out.print('E'); // Enemy position
                } else {
                    System.out.print('.'); // Empty space
                }
                System.out.print(' ');
            }
            System.out.println();
        }
    }
}