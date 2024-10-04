# Matrix Multiplication

This task introduces Java concepts—namely `Arrays`, `ArrayLists`, the `static` keyword, and combining loops and collections—through creating a matrix multiplication program. By the end, you should have a good grasp of handling complex data structures in Java.

### 📝 Preparation

- Review the [lecture slides](https://your_lecture_slides_link)
- Read and answer all questions in the [Module 7: Multidimensional Arrays](https://your_module_link)

### ✅ Learning Goals

This week's learning goals include:

- 🛠️ Working with `Arrays`
- 🔍 Understanding the `static` keyword
- 📚 Working with `ArrayLists`
- 🔀 Combining loops and collections

### 🚨 Troubleshooting Guide

If you have any questions or problems, follow this procedure:

1. Look at this week's [posted issues](https://your_github_issues_link). Are other students asking about your problem?
2. If not, post a question yourself by creating a [New Issue](https://your_github_new_issue_link). Add a descriptive title, beginning with "Task *x*: *summary of problem here*."
3. Ask a TA in person during the [weekly lab](https://your_weekly_lab_link). Check your schedule for timing.

We encourage you to discuss with your course friends, **but do not share answers!** Similarly, use any AI services 🤖 wisely for understanding, **but please do not submit AI-generated solutions** - you must be responsible for your solutions and able to explain them during examinations.

### 🏛 Assignment

A matrix is a powerful data structure that can represent complex transformations and data relationships. This week's assignment is to implement matrix multiplication in Java using both `Arrays` and `ArrayLists`.

<details>
<summary> 📚 Understanding Java Arrays </summary>

Java's single-dimension `Array` can be visualized like this:

```
array: | a | b | c | d |
index:   0   1   2   3
```

Matrices can be represented as two-dimensional arrays:

```java
public class MatrixExample {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2},
            {3, 4},
            {5, 6}
        };
    }
}
```

The above represents a 3x2 matrix. You access elements via `matrix[i][j]`.
---
</details>

<details>
<summary> 📚 Introduction to ArrayLists </summary>

An `ArrayList` can grow dynamically, unlike an `Array`. Here's how you can create one:

```java
import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add(1);
        row1.add(2);
        matrix.add(row1);

        ArrayList<Integer> row2 = new ArrayList<>();
        row2.add(3);
        row2.add(4);
        matrix.add(row2);
    }
}
```

You can dynamically adjust `ArrayList` sizes, making them ideal for matrix operations where dimensions might vary.
---
</details>

<details>
<summary> 📚 The Static Keyword </summary>

Static methods belong to the class, not instances, allowing you to invoke methods without creating an instance:

```java
public class MathUtils {

    public static int multiply(int a, int b) {
        return a * b;
    }
    
    public static void main(String[] args) {
        int result = MathUtils.multiply(5, 10);
        System.out.println("Result: " + result);
    }
}
```

Static methods are particularly helpful in utility classes.
---
</details>

#### Exercise 7.0 -- Setting up the Matrix class

Begin by creating a new class called `Matrix` in a file named `Matrix.java`. This class will hold your solutions to the following tasks.

#### Exercise 7.1 -- Matrix Multiplication with Static Methods

Write a `static` method that multiplies two matrices represented as `int[][]` arrays. The result should be a new matrix represented by an `int[][]` array. Use the following method header:

```java
public static int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB)
```

- If the number of columns in `matrixA` does not equal the number of rows in `matrixB`, throw an `IllegalArgumentException`.
  
> **Assistant's Note:** Use nested loops to multiply matrices. Remember, element `(i, j)` in the resulting matrix is the sum of the products of the elements of the i-th row of the first matrix and the j-th column of the second matrix.

#### Exercise 7.2 -- Convert to Using ArrayLists

Refactor the matrix multiplication method to use `ArrayList<ArrayList<Integer>>` instead of `int[][]`. Use the following header:

```java
public static ArrayList<ArrayList<Integer>> multiplyMatrixLists(ArrayList<ArrayList<Integer>> matrixA, ArrayList<ArrayList<Integer>> matrixB)
```

> **Assistant's Note:** Leverage ArrayList methods like `get()` and `add()`, and employ nested `for` loops to handle the matrix dimensions dynamically.

#### Exercise 7.3 -- Utility Method for Printing Matrices

Create a utility `static` method to print matrices for better visualization during debugging. This method should work for both `int[][]` and `ArrayList<ArrayList<Integer>>`.

```java
public static void printMatrix(int[][] matrix)
public static void printMatrix(ArrayList<ArrayList<Integer>> matrix)
```

The `printMatrix` method should print each element in a format resembling a matrix on the console.

#### Exercise 7.4 -- Adapter Method for Conversions

Write an adapter method that converts an `ArrayList<ArrayList<Integer>>` to `int[][]` and vice versa. These conversions will help you streamline work between different data structures:

```java
public static int[][] toArray(ArrayList<ArrayList<Integer>> matrixList)
public static ArrayList<ArrayList<Integer>> toArrayList(int[][] matrixArray)
```

#### Exercise 7.5 -- Test Your Solution

Create a `main` method in `Matrix.java` to test all methods with some examples. Make sure your code is robust and well-handled for edge cases such as invalid dimensions for multiplication.

Implement rigorous tests and print the results to verify the correctness of your implementation:

```java
public static void main(String[] args) {
    // Define matrixA and matrixB
    int[][] matrixA = {{1, 2}, {3, 4}};
    int[][] matrixB = {{5, 6}, {7, 8}};

    // Test matrix multiplication
    int[][] product = multiplyMatrices(matrixA, matrixB);
    printMatrix(product);
    
    // Convert matrices to ArrayLists
    ArrayList<ArrayList<Integer>> listA = toArrayList(matrixA);
    ArrayList<ArrayList<Integer>> listB = toArrayList(matrixB);

    // Test ArrayList-based multiplication
    ArrayList<ArrayList<Integer>> productList = multiplyMatrixLists(listA, listB);
    printMatrix(productList);
}
```

This assignment should challenge you to combine loops and collections while handling complex data structures in Java. Implement each part thoroughly to strengthen your understanding of both Java and real-world programming concepts!