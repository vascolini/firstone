package cz.upce.fei.zzapr.w06;



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class MatrixMultiplicationTest {

    @Test
    public void testValidMatrixSize() {
        int[][] validMatrix = {{1, 2}, {3, 4}};
        int[][] emptyMatrix = {};
        int[][] nullMatrix = null;

        assertTrue(MatrixMultiplication.validMatrixSize(validMatrix));
        assertFalse(MatrixMultiplication.validMatrixSize(emptyMatrix));
        assertFalse(MatrixMultiplication.validMatrixSize(nullMatrix));
    }

    @Test
    public void testMultiplyMatrices() {
        int[][] matrix1 = {{1, 2}, {3, 4}};
        int[][] matrix2 = {{1, 0}, {0, 1}};
        int[][] expectedProduct = {{1, 2}, {3, 4}};

        int[][] product = MatrixMultiplication.multiplyMatrices(matrix1, matrix2);

        assertArrayEquals(expectedProduct, product);
    }

    @Test
    public void testReadMatrix() {
        String input = "1 2\n3 4\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int[][] expectedMatrix = {{1, 2}, {3, 4}};
        int[][] matrix = MatrixMultiplication.readMatrix(new java.util.Scanner(System.in), 2, 2);

        assertArrayEquals(expectedMatrix, matrix);
    }
}
