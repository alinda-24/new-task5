package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SimpleGameApplicationTest {

    private SimpleGameApplication game;

    @Before
    public void setUp() {
        game = new SimpleGameApplication();
        SimpleGameApplication.gameGrid = new int[SimpleGameApplication.GRID_SIZE][SimpleGameApplication.GRID_SIZE];
        SimpleGameApplication.playerPosition = new int[]{0, 0};
        SimpleGameApplication.score = 0;
        SimpleGameApplication.enemies.clear();
    }

    @Test
    public void testInitialPlayerPosition() {
        assertEquals(0, SimpleGameApplication.playerPosition[0]);
        assertEquals(0, SimpleGameApplication.playerPosition[1]);
    }

    @Test
    public void testPlaceItems() {
        int itemCount = 5;
        SimpleGameApplication.placeItems(itemCount);
        int actualItemCount = 0;

        for (int[] row : SimpleGameApplication.gameGrid) {
            for (int cell : row) {
                if (cell == SimpleGameApplication.ITEM) {
                    actualItemCount++;
                }
            }
        }
        
        assertEquals(itemCount, actualItemCount);
    }

    @Test
    public void testSpawnEnemies() {
        int enemyCount = 3;
        SimpleGameApplication.spawnEnemies(enemyCount);
        int actualEnemyCount = 0;

        for (int[] row : SimpleGameApplication.gameGrid) {
            for (int cell : row) {
                if (cell == SimpleGameApplication.ENEMY) {
                    actualEnemyCount++;
                }
            }
        }
        
        assertEquals(enemyCount, actualEnemyCount);
    }

    @Test
    public void testMovePlayerValidMoves() {
        SimpleGameApplication.movePlayer('d'); // right
        assertEquals(1, SimpleGameApplication.playerPosition[1]);

        SimpleGameApplication.movePlayer('s'); // down
        assertEquals(1, SimpleGameApplication.playerPosition[0]);

        SimpleGameApplication.movePlayer('a'); // left
        assertEquals(0, SimpleGameApplication.playerPosition[1]);

        SimpleGameApplication.movePlayer('w'); // up
        assertEquals(0, SimpleGameApplication.playerPosition[0]);
    }

    @Test
    public void testMovePlayerInvalidMoves() {
        SimpleGameApplication.movePlayer('x'); // invalid
        assertEquals(0, SimpleGameApplication.playerPosition[0]);
        assertEquals(0, SimpleGameApplication.playerPosition[1]);
    }

    @Test
    public void testPlayerScoreAfterCollectingItem() {
        SimpleGameApplication.gameGrid[1][0] = SimpleGameApplication.ITEM;
        SimpleGameApplication.movePlayer('s'); // move down to collect item
        assertEquals(10, SimpleGameApplication.score);
    }

    @Test
    public void testUpdateEnemiesRandomMovement() {
        SimpleGameApplication.enemies.add(new int[]{1, 1});
        SimpleGameApplication.updateEnemies();

        boolean enemyMoved = false;
        for (int[][] direction : new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}) {
            int x = 1 + direction[0];
            int y = 1 + direction[1];
            if (x >= 0 && x < SimpleGameApplication.GRID_SIZE &&
                y >= 0 && y < SimpleGameApplication.GRID_SIZE &&
                SimpleGameApplication.gameGrid[x][y] == SimpleGameApplication.ENEMY) {
                enemyMoved = true;
                break;
            }
        }

        assertTrue(enemyMoved);
    }

    @Test
    public void testCheckCollisions() {
        SimpleGameApplication.enemies.add(new int[]{0, 0});
        try {
            SimpleGameApplication.checkCollisions();
            fail("Expected System.exit to be called");
        } catch (Exception e) {
            // Success if exception is thrown as System.exit would stop test execution
        }
    }
}