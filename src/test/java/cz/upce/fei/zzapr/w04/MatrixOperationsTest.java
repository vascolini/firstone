package cz.upce.fei.zzapr.w04;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MatrixOperationsTest {

    @Test
    public void testSumMatrices() {
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix2 = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
        int[][] expectedResult = {{10, 10, 10}, {10, 10, 10}, {10, 10, 10}};
        int[][] result = MatrixOperations.sumMatrices(matrix1, matrix2);
        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testMatrixSizeDifferent() {
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix2 = {{9, 8, 7}, {6, 5, 5}, {3, 3}};
        assertFalse(MatrixOperations.isSameSize(matrix1, matrix2));
    }

    @Test
    public void testMatrixSizeSame() {
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix2 = {{9, 8, 7}, {6, 9, 5}, {3, 3, 3}};
        assertTrue(MatrixOperations.isSameSize(matrix1, matrix2));
    }
}
