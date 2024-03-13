package cz.upce.fei.zzapr.w04;

import java.util.Scanner;

public class MatrixSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input matrix dimensions
        System.out.println("Enter the number of rows for both matrices:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of columns for both matrices:");
        int columns = scanner.nextInt();

        // Input the first matrix
        System.out.println("Enter elements of the first matrix:");
        int[][] matrix1 = MatrixInput.readMatrix(scanner, rows, columns);

        // Input the second matrix
        System.out.println("Enter elements of the second matrix:");
        int[][] matrix2 = MatrixInput.readMatrix(scanner, rows, columns);

        // Sum the matrices
        int[][] sum = MatrixOperations.sumMatrices(matrix1, matrix2);

        // Display the result
        MatrixOutput.printMatrix(sum);

        scanner.close();
    }
}

class MatrixInput {

    public static int[][] readMatrix(Scanner scanner, int rows, int columns) {
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }
}

class MatrixOperations {
    public static int[][] sumMatrices(int[][] matrix1, int[][] matrix2) {
        if (!isSameSize(matrix1, matrix2)) {
            throw new IllegalArgumentException("Matrices must have the same size for summation.");
        }

        int rows = matrix1.length;
        int columns = matrix1[0].length;
        int[][] sum = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sum[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return sum;
    }

    public static boolean isSameSize(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int columns1 = matrix1[0].length;
        int rows2 = matrix2.length;
        int columns2 = matrix2[0].length;
        if (rows1 != rows2 || columns1 != columns2) {
            return false;
        }
        for (int i = 0; i < rows1; i++) {
            if (matrix1[i].length != columns1 || matrix2[i].length != columns2) {
                return false;
            }
        }
        return true;
    }

}


class MatrixOutput {

    // Method to print a matrix
    public static void printMatrix(int[][] matrix) {
        // Get the number of rows and columns in the matrix
        int rows = matrix.length;
        int columns = matrix[0].length;

        // Iterate over each row
        for (int i = 0; i < rows; i++) {
            // Print each element in the row
            printRow(matrix[i]);
            // Move to the next line after printing a row
            System.out.println();
        }
    }

    // Method to print a single row of the matrix
    private static void printRow(int[] row) {
        // Iterate over each element in the row
        for (int num : row) {
            // Print the element followed by a space
            System.out.print(num + " ");
        }
    }
}