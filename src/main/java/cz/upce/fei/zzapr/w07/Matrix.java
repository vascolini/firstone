package cz.upce.fei.zzapr.w07;

import java.util.Scanner;

public class Matrix {
    private final int[][] matrix;
    private final int rows;
    private final int columns;

    public Matrix(int rows, int columns) {
        if (rows <= 0 || columns <= 0) {
            throw new IllegalArgumentException("Matrix dimensions must be positive");
        }
        this.rows = rows;
        this.columns = columns;
        this.matrix = new int[rows][columns];
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setElement(int row, int column, int value) {
        if (row < 0 || row >= rows || column < 0 || column >= columns) {
            throw new IndexOutOfBoundsException("Invalid row or column index");
        }
        matrix[row][column] = value;
    }

    public int getElement(int row, int column) {
        if (row < 0 || row >= rows || column < 0 || column >= columns) {
            throw new IndexOutOfBoundsException("Invalid row or column index");
        }
        return matrix[row][column];
    }

    public static Matrix readMatrix(Scanner scanner, int rows, int columns) {
        Matrix matrix = new Matrix(rows, columns);
        System.out.println("Enter elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (!scanner.hasNextInt()) {
                    throw new IllegalArgumentException("Input is not a valid integer");
                }
                matrix.setElement(i, j, scanner.nextInt());
            }
        }
        return matrix;
    }
}

