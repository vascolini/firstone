package cz.upce.fei.zzapr.w04;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class MatrixTest {

    @Test
    public void testMatrixSum() {
        // Create two matrices
        Matrix matrix1 = new Matrix(2, 2);
        Matrix matrix2 = new Matrix(2, 2);

        // Set values for the first matrix
        matrix1.getMatrix()[0][0] = 1;
        matrix1.getMatrix()[0][1] = 2;
        matrix1.getMatrix()[1][0] = 3;
        matrix1.getMatrix()[1][1] = 4;

        // Set values for the second matrix
        matrix2.getMatrix()[0][0] = 5;
        matrix2.getMatrix()[0][1] = 6;
        matrix2.getMatrix()[1][0] = 7;
        matrix2.getMatrix()[1][1] = 8;

        // Calculate the sum
        Matrix sum = matrix1.sum(matrix2);

        // Check if the sum is calculated correctly
        int[][] expectedSum = {{6, 8}, {10, 12}};
        assertArrayEquals(expectedSum, sum.getMatrix());
    }

    @Test
    public void testMatrixSumWithSameSize() {
        // Create two matrices
        Matrix matrix1 = new Matrix(2, 2);
        Matrix matrix2 = new Matrix(2, 2);

        // Set values for the matrices
        matrix1.getMatrix()[0][0] = 1;
        matrix1.getMatrix()[0][1] = 2;
        matrix1.getMatrix()[1][0] = 3;
        matrix1.getMatrix()[1][1] = 4;

        matrix2.getMatrix()[0][0] = 5;
        matrix2.getMatrix()[0][1] = 6;
        matrix2.getMatrix()[1][0] = 7;
        matrix2.getMatrix()[1][1] = 8;

        // Calculate the sum
        Matrix sum = matrix1.sum(matrix2);

        // Check if the sum is calculated correctly
        int[][] expectedSum = {{6, 8}, {10, 12}};
        assertArrayEquals(expectedSum, sum.getMatrix());
    }

    @Test
    public void testMatrixSumWithDifferentSize() {
        // Create two matrices with different sizes
        Matrix matrix1 = new Matrix(2, 2);
        Matrix matrix2 = new Matrix(3, 3);

        // Set values for the matrices
        matrix1.getMatrix()[0][0] = 1;
        matrix1.getMatrix()[0][1] = 2;
        matrix1.getMatrix()[1][0] = 3;
        matrix1.getMatrix()[1][1] = 4;

        matrix2.getMatrix()[0][0] = 5;
        matrix2.getMatrix()[0][1] = 6;
        matrix2.getMatrix()[0][2] = 7;
        matrix2.getMatrix()[1][0] = 8;
        matrix2.getMatrix()[1][1] = 9;
        matrix2.getMatrix()[1][2] = 10;
        matrix2.getMatrix()[2][0] = 11;
        matrix2.getMatrix()[2][1] = 12;
        matrix2.getMatrix()[2][2] = 13;

        // Verify that an IllegalArgumentException is thrown when attempting to sum matrices with different sizes
        assertThrows(IllegalArgumentException.class, () -> matrix1.sum(matrix2));
    }
}
