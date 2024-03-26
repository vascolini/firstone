package cz.upce.fei.zzapr.w06;



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MatrixTest {

    @Test
    public void testMatrixMultiplication() {
        Matrix matrix1 = new Matrix(2, 3);
        matrix1.setElement(0, 0, 1);
        matrix1.setElement(0, 1, 2);
        matrix1.setElement(0, 2, 3);
        matrix1.setElement(1, 0, 4);
        matrix1.setElement(1, 1, 5);
        matrix1.setElement(1, 2, 6);

        Matrix matrix2 = new Matrix(3, 2);
        matrix2.setElement(0, 0, 7);
        matrix2.setElement(0, 1, 8);
        matrix2.setElement(1, 0, 9);
        matrix2.setElement(1, 1, 10);
        matrix2.setElement(2, 0, 11);
        matrix2.setElement(2, 1, 12);

        Matrix expectedProduct = new Matrix(2, 2);
        expectedProduct.setElement(0, 0, 58);
        expectedProduct.setElement(0, 1, 64);
        expectedProduct.setElement(1, 0, 139);
        expectedProduct.setElement(1, 1, 154);

        Matrix product = Matrix.multiplyMatrices(matrix1, matrix2);

        assertNotNull(product);
        assertArrayEquals(expectedProduct.getMatrix(), product.getMatrix());
    }

    @Test
    public void testInvalidMatrixSize() {
        Matrix emptyMatrix = new Matrix(0, 0);
        assertFalse(Matrix.validMatrixSize(emptyMatrix));

        Matrix nullMatrix = null;
        assertFalse(Matrix.validMatrixSize(nullMatrix));

        Matrix nonEmptyMatrix = new Matrix(2, 2);
        assertTrue(Matrix.validMatrixSize(nonEmptyMatrix));
    }


    @Test
    public void testValidMatrixSize() {
            // Create a matrix with valid size
        Matrix matrix = new Matrix(2, 2);

            // Check if the matrix size is valid
        assertTrue(Matrix.validMatrixSize(matrix));
    }




}
