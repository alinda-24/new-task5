package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MatrixTest {

    @Test
    public void testMatrixMultiplicationWithValidInput() {
        int[][] matrixA = {{1, 2}, {3, 4}};
        int[][] matrixB = {{5, 6}, {7, 8}};
        int[][] expected = {{19, 22}, {43, 50}};

        int[][] result = Matrix.multiplyMatrices(matrixA, matrixB);

        assertArrayEquals(expected, result);
    }

    @Test
    public void testMatrixMultiplicationWithIncompatibleMatrices() {
        int[][] matrixA = {{1, 2, 3}, {4, 5, 6}};
        int[][] matrixB = {{7, 8}, {9, 10}};
        
        assertThrows(IllegalArgumentException.class, () -> {
            Matrix.multiplyMatrices(matrixA, matrixB);
        });
    }

    @Test
    public void testArrayListMatrixMultiplicationWithValidInput() {
        ArrayList<ArrayList<Integer>> matrixA = new ArrayList<>();
        ArrayList<ArrayList<Integer>> matrixB = new ArrayList<>();
        
        // Initialize matrixA
        ArrayList<Integer> rowA1 = new ArrayList<>(); rowA1.add(1); rowA1.add(2);
        ArrayList<Integer> rowA2 = new ArrayList<>(); rowA2.add(3); rowA2.add(4);
        matrixA.add(rowA1);
        matrixA.add(rowA2);

        // Initialize matrixB
        ArrayList<Integer> rowB1 = new ArrayList<>(); rowB1.add(5); rowB1.add(6);
        ArrayList<Integer> rowB2 = new ArrayList<>(); rowB2.add(7); rowB2.add(8);
        matrixB.add(rowB1);
        matrixB.add(rowB2);

        ArrayList<ArrayList<Integer>> result = Matrix.multiplyMatrixLists(matrixA, matrixB);

        // Expected result
        ArrayList<ArrayList<Integer>> expected = new ArrayList<>();
        ArrayList<Integer> rowE1 = new ArrayList<>(); rowE1.add(19); rowE1.add(22);
        ArrayList<Integer> rowE2 = new ArrayList<>(); rowE2.add(43); rowE2.add(50);
        expected.add(rowE1);
        expected.add(rowE2);

        assertEquals(expected, result);
    }

    @Test
    public void testArrayListMatrixMultiplicationWithIncompatibleMatrices() {
        ArrayList<ArrayList<Integer>> matrixA = new ArrayList<>();
        ArrayList<ArrayList<Integer>> matrixB = new ArrayList<>();
        
        // Initialize matrixA
        ArrayList<Integer> rowA1 = new ArrayList<>(); rowA1.add(1);
        matrixA.add(rowA1);

        // Initialize matrixB
        ArrayList<Integer> rowB1 = new ArrayList<>(); rowB1.add(5); rowB1.add(6);
        matrixB.add(rowB1);

        assertThrows(IllegalArgumentException.class, () -> {
            Matrix.multiplyMatrixLists(matrixA, matrixB);
        });
    }

    @Test
    public void testToArrayWithValidInput() {
        ArrayList<ArrayList<Integer>> matrixList = new ArrayList<>();
        
        // Initialize matrixList
        ArrayList<Integer> row1 = new ArrayList<>(); row1.add(1); row1.add(2);
        ArrayList<Integer> row2 = new ArrayList<>(); row2.add(3); row2.add(4);
        matrixList.add(row1);
        matrixList.add(row2);

        int[][] expected = {{1, 2}, {3, 4}};
        int[][] result = Matrix.toArray(matrixList);

        assertArrayEquals(expected, result);
    }

    @Test
    public void testToArrayListWithValidInput() {
        int[][] matrixArray = {{1, 2}, {3, 4}};

        ArrayList<ArrayList<Integer>> expected = new ArrayList<>();
        
        // Expected ArrayList
        ArrayList<Integer> row1 = new ArrayList<>(); row1.add(1); row1.add(2);
        ArrayList<Integer> row2 = new ArrayList<>(); row2.add(3); row2.add(4);
        expected.add(row1);
        expected.add(row2);

        ArrayList<ArrayList<Integer>> result = Matrix.toArrayList(matrixArray);

        assertEquals(expected, result);
    }

    @Test
    public void testEmptyMatrixMultiplication() {
        int[][] matrixA = {};
        int[][] matrixB = {};

        try {
            int[][] result = Matrix.multiplyMatrices(matrixA, matrixB);
            assertArrayEquals(new int[][] {}, result);
        } catch (Exception e) {
            fail("Exception should not be thrown for multiplying empty matrices.");
        }
    }

    @Test
    public void testEmptyArrayListMatrixMultiplication() {
        ArrayList<ArrayList<Integer>> matrixA = new ArrayList<>();
        ArrayList<ArrayList<Integer>> matrixB = new ArrayList<>();

        try {
            ArrayList<ArrayList<Integer>> result = Matrix.multiplyMatrixLists(matrixA, matrixB);
            assertEquals(new ArrayList<>(), result);
        } catch (Exception e) {
            fail("Exception should not be thrown for multiplying empty ArrayList matrices.");
        }
    }
}