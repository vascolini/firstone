package cz.upce.fei.zzapr.w06;

import java.util.Scanner;

public class Matrix {
    private int[][] matrix;
    private int rows;
    private int columns;

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        matrix = new int[rows][columns];
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setElement(int row, int column, int value) {
        matrix[row][column] = value;
    }

    public int getElement(int row, int column) {
        return matrix[row][column];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public static Matrix readMatrix(Scanner scanner, int rows, int columns) {
        Matrix matrix = new Matrix(rows, columns);
        System.out.println("Enter elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix.setElement(i, j, scanner.nextInt());
            }
        }
        return matrix;
    }

    public static Matrix multiplyMatrices(Matrix matrix1, Matrix matrix2) {
        int rows1 = matrix1.getRows();
        int columns1 = matrix1.getColumns();
        int rows2 = matrix2.getRows();
        int columns2 = matrix2.getColumns();

        if (columns1 != rows2) {
            System.out.println("Matrices cannot be multiplied. Number of columns of the first matrix " +
                    "must be equal to the number of rows of the second matrix.");
            return null;
        }

        Matrix product = new Matrix(rows1, columns2);
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < columns2; j++) {
                for (int k = 0; k < rows2; k++) {
                    product.setElement(i, j, product.getElement(i, j) + matrix1.getElement(i, k) * matrix2.getElement(k, j));
                }
            }
        }
        return product;
    }

    public static void printMatrix(Matrix matrix) {
        int rows = matrix.getRows();
        int columns = matrix.getColumns();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix.getElement(i, j) + " ");
            }
            System.out.println();
        }
    }

    public static boolean validMatrixSize(Matrix matrix) {
        if (matrix == null || matrix.getRows() == 0 || matrix.getColumns() == 0) {
            return false; // Empty or null matrix
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows for the first matrix:");
        int rows1 = scanner.nextInt();
        System.out.println("Enter the number of columns for the first matrix:");
        int columns1 = scanner.nextInt();

        System.out.println("Enter the number of rows for the second matrix:");
        int rows2 = scanner.nextInt();
        System.out.println("Enter the number of columns for the second matrix:");
        int columns2 = scanner.nextInt();

        Matrix matrix1 = readMatrix(scanner, rows1, columns1);
        Matrix matrix2 = readMatrix(scanner, rows2, columns2);

        if (!validMatrixSize(matrix1) || !validMatrixSize(matrix2)) {
            System.out.println("Invalid matrix size");
            return;
        }

        Matrix product = multiplyMatrices(matrix1, matrix2);

        if (product != null) {
            System.out.println("Product of the matrices:");
            printMatrix(product);
        }

        scanner.close();
    }
}
