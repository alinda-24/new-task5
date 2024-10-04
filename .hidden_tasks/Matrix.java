import java.util.List;
import java.util.ArrayList;

public class Matrix {

    // Exercise 7.1 -- Matrix Multiplication with Static Methods
    public static int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int rowsB = matrixB.length;
        int colsB = matrixB[0].length;

        if (colsA != rowsB) {
            throw new IllegalArgumentException("Number of columns in Matrix A must be equal to number of rows in Matrix B");
        }

        int[][] result = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                result[i][j] = 0;
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        return result;
    }

    // Exercise 7.2 -- Convert to Using ArrayLists
    public static ArrayList<ArrayList<Integer>> multiplyMatrixLists(ArrayList<ArrayList<Integer>> matrixA, ArrayList<ArrayList<Integer>> matrixB) {
        int rowsA = matrixA.size();
        int colsA = matrixA.get(0).size();
        int rowsB = matrixB.size();
        int colsB = matrixB.get(0).size();

        if (colsA != rowsB) {
            throw new IllegalArgumentException("Number of columns in Matrix A must be equal to number of rows in Matrix B");
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < rowsA; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < colsB; j++) {
                int sum = 0;
                for (int k = 0; k < colsA; k++) {
                    sum += matrixA.get(i).get(k) * matrixB.get(k).get(j);
                }
                row.add(sum);
            }
            result.add(row);
        }
        return result;
    }

    // Exercise 7.3 -- Utility Method for Printing Matrices
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void printMatrix(ArrayList<ArrayList<Integer>> matrix) {
        for (ArrayList<Integer> row : matrix) {
            for (Integer val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    // Exercise 7.4 -- Adapter Method for Conversions
    public static int[][] toArray(ArrayList<ArrayList<Integer>> matrixList) {
        int rows = matrixList.size();
        int cols = matrixList.get(0).size();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = matrixList.get(i).get(j);
            }
        }
        return matrix;
    }

    public static ArrayList<ArrayList<Integer>> toArrayList(int[][] matrixArray) {
        ArrayList<ArrayList<Integer>> matrixList = new ArrayList<>();
        for (int[] row : matrixArray) {
            ArrayList<Integer> rowList = new ArrayList<>();
            for (int val : row) {
                rowList.add(val);
            }
            matrixList.add(rowList);
        }
        return matrixList;
    }

    // Exercise 7.5 -- Test Your Solution
    public static void main(String[] args) {
        // Define matrixA and matrixB
        int[][] matrixA = {{1, 2}, {3, 4}};
        int[][] matrixB = {{5, 6}, {7, 8}};

        // Test matrix multiplication
        int[][] product = multiplyMatrices(matrixA, matrixB);
        System.out.println("Matrix multiplication with arrays:");
        printMatrix(product);

        // Convert matrices to ArrayLists
        ArrayList<ArrayList<Integer>> listA = toArrayList(matrixA);
        ArrayList<ArrayList<Integer>> listB = toArrayList(matrixB);

        // Test ArrayList-based multiplication
        ArrayList<ArrayList<Integer>> productList = multiplyMatrixLists(listA, listB);
        System.out.println("Matrix multiplication with ArrayLists:");
        printMatrix(productList);
    }
}