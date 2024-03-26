package cz.upce.fei.zzapr.w04;

import java.util.Scanner;

public class Matrix {
    private int[][] matrix;

    public int[][] getMatrix() {
        return matrix;
    }


    public Matrix(int rows, int columns) {
        matrix = new int[rows][columns];
    }

    public void readMatrix(Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    public Matrix sum(Matrix other) {
        if (!isSameSize(other)) {
            throw new IllegalArgumentException("Matrices must have the same size for summation.");
        }

        Matrix result = new Matrix(matrix.length, matrix[0].length);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result.matrix[i][j] = this.matrix[i][j] + other.matrix[i][j];
            }
        }
        return result;
    }

    private boolean isSameSize(Matrix other) {
        return matrix.length == other.matrix.length && matrix[0].length == other.matrix[0].length;
    }

    public void printMatrix() {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows for both matrices:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of columns for both matrices:");
        int columns = scanner.nextInt();

        System.out.println("Enter elements of the first matrix:");
        Matrix matrix1 = new Matrix(rows, columns);
        matrix1.readMatrix(scanner);

        System.out.println("Enter elements of the second matrix:");
        Matrix matrix2 = new Matrix(rows, columns);
        matrix2.readMatrix(scanner);

        Matrix sum = matrix1.sum(matrix2);

        System.out.println("Sum of the matrices:");
        sum.printMatrix();

        scanner.close();
    }
}
