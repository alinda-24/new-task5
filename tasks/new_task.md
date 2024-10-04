# Create a Simple Game Application

This week, you'll be diving into game development by creating a simple application incorporating key programming concepts like player movement, a scoring system, and enemy interactions. You'll utilize Java collections such as `Arrays` and `ArrayList` to organize your objects and behaviors.

### 📝 Preparation

- Review the [lecture slides](https://docs.google.com/presentation/d/1qIjQ10Dy7RW00wit0Ud5vX_012pH_1chOcuvpkt03cg/edit#slide=id.p)
- Read and answer all questions in [Module 5: Grouping Objects](https://qbl.sys.kth.se/sections/dd1337_programming/container/grouping_objects)

### ✅ Learning Goals

This week's learning goals include:

* Working with `Arrays`
* Understanding the `static` keyword
* Working with `ArrayLists`
* Combining loops and collections

### 🚨 Troubleshooting Guide

If you have any questions or problems, follow this procedure: <br/>

1. Look at this week's [posted issues](https://gits-15.sys.kth.se/inda-24/help/issues). Are other students asking about your problem?
2. If not, post a question yourself by creating a [New Issue](https://gits-15.sys.kth.se/inda-24/help/issues/new). Add a descriptive title, beginning with "Task X: summary of problem here"
3. Ask a TA in person during the [weekly lab](https://queue.csc.kth.se/Queue/INDA). Check your schedule to see when the next lab is.

We encourage you to discuss with your course friends, **but do not share answers!** Use AI services 🤖 as needed to understand concepts, but **do not submit AI-generated solutions** - your solutions should be your own.

### 🎮 Assignment

You will create a simple 2D game where the player can move within a grid, collect items for points, and avoid enemies. The task is divided into understanding and manipulating collections in Java.

#### 🎲 Task Overview

1. **Player Movement**: Allow the player to move up, down, left, and right.
2. **Scoring System**: Implement a mechanism to increase the player's score when collecting items.
3. **Enemy Interactions**: Create enemies that the player needs to avoid.

<details>
<summary> 📚 Working with Arrays </summary>

You will use arrays to manage the grid and the player's position. Arrays help store fixed-size sequences of elements of the same data type:

```java
public static int[][] gameGrid = new int[10][10]; // 10x10 grid
public static int playerPosition[] = {0, 0}; // Player starts at the top-left corner
```

Along with using loops, arrays allow you to easily manage grid-based operations.

</details>

<details>
<summary> 📚 Understanding the static keyword </summary>

The `static` keyword defines methods and variables shared across all instances of a class. For global elements like the game grid or score, `static` is appropriate:

```java
public static int score = 0;
```

All methods that deal with updating the grid based on static elements should also be static. This organization keeps logic centralized and modifiable without requiring instantiation of objects.

</details>

<details>
<summary> 📚 Using ArrayLists for dynamic collections </summary>

While arrays serve well for fixed-size data, `ArrayLists` allow dynamic sizing, especially for storing a list of enemies:

```java
import java.util.ArrayList;

public static ArrayList<int[]> enemies = new ArrayList<>();
```

The `ArrayList` class provides helpful methods like `add()`, `remove()`, and `get()`, making it easier to work with dynamic collections. 

</details>

<details>
<summary> 📚 Combining Loops and Collections </summary>

Effective use of loops with arrays and `ArrayLists` is vital for iterating over elements, updating states, and managing interactions.

Example of iterating over enemies in `ArrayList` using a for-each loop:

```java
for (int[] enemy : enemies) {
    // Update enemy position or check interaction with player
}
```

The use of both conventional for-loops and enhanced for-loops (`foreach`) will be crucial in implementing game logic efficiently.

</details>

### 🏛 Detailed Exercises

#### Exercise 1: Implement the Game Grid and Player Movement

1. Define a 2D `int` array representing the game grid.
2. Use an `int[]` array to hold the player's position.
3. Create a static method `movePlayer(char direction)` using `Arrays` and simple `if-else` conditions to update the player's position. Utilize the grid to ensure the player doesn't move out of bounds.
   
#### Exercise 2: Implement a Scoring System

1. Define a `static int score` to store the player's score.
2. Add items randomly on the grid that increase the score when collected by the player.
3. Develop a static method `collectItem()` to update the player's score and remove the item from the grid.

#### Exercise 3: Implement Dynamic Enemy Interactions

1. Use `ArrayList<int[]>` to store multiple enemies' positions.
2. Create a static method `spawnEnemies(int count)` to add enemies at random grid positions.
3. Write a static method `updateEnemies()` using loops to move enemies and check for collisions with the player.
4. Implement a static method `checkCollisions()` ensuring player colliding with enemies results in a game over.

#### Exercise 4: Game Loop Simulation

1. Develop a `static` game loop (e.g., `runGame()`) that combines all elements using loops.
2. Create simple input handling to let the player choose movements.
3. Continuously update and render the game state in the console.

This task leverages your understanding of collections in Java, dynamic memory management, `static` properties, and creative problem-solving in game design. Good luck building your first interactive 2D game! 🎉