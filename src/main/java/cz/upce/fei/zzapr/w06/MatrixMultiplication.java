package cz.upce.fei.zzapr.w06;

import java.util.Scanner;

public class MatrixMultiplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input matrix dimensions
        System.out.println("Enter the number of rows for the first matrix:");
        int rows1 = scanner.nextInt();
        System.out.println("Enter the number of columns for the first matrix:");
        int columns1 = scanner.nextInt();

        System.out.println("Enter the number of rows for the second matrix:");
        int rows2 = scanner.nextInt();
        System.out.println("Enter the number of columns for the second matrix:");
        int columns2 = scanner.nextInt();

        // Check if the matrices can be multiplied
        if (columns1 != rows2) {
            System.out.println("Matrices cannot be multiplied. Number of columns of the first matrix " +
                    "must be equal to the number of rows of the second matrix.");
            return;
        }

        // Input the first matrix
        System.out.println("Enter elements of the first matrix:");
        int[][] matrix1 = readMatrix(scanner, rows1, columns1);

        if (!MatrixMultiplication.validMatrixSize(matrix1)) {
            System.out.println("you cannot do this the nunber of rows and colums are not the same");
        }
        // Input the second matrix
        System.out.println("Enter elements of the second matrix:");
        int[][] matrix2 = readMatrix(scanner, rows2, columns2);



        // Multiply the matrices
        int[][] product = multiplyMatrices(matrix1, matrix2);

        // Display the result
        System.out.println("Product of the matrices:");
        printMatrix(product);

        scanner.close();

    }
    public static int[][] readMatrix(Scanner scanner, int rows, int columns) {
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int columns1 = matrix1[0].length;
        int rows2 = matrix2.length;
        int columns2 = matrix2[0].length;
        int[][] product = new int[rows1][columns2];
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < columns2; j++) {
                for (int k = 0; k < rows2; k++) {
                    product[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return product;
    }

    public static void printMatrix(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean validMatrixSize(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false; // Empty or null matrix
        }

        int rows = matrix.length;
        int columns = matrix[0].length;

        return rows > 0 && columns > 0;
    }
}
