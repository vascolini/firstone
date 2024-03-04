package cz.upce.fei.zzapr.w02;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the size of the table from the user
        System.out.print("Enter the size of the multiplication table: ");
        int size = scanner.nextInt();

        printMultiplicationTable(size);

        scanner.close();
    }

    public static void printMultiplicationTable(int size) {
        printHeader(size);

        for (int i = 1; i <= size; i++) {
            printRow(i, size);
            if (i != size) {
                printLine(size);
            }
        }
    }

    public static void printHeader(int size) {
        System.out.print("   |");
        for (int i = 1; i <= size; i++) {
            System.out.printf("%5d", i);
            if (i != size) {
                System.out.print("  |");
            }
        }
        System.out.println();
        printLine(size);

    }

    public static void printRow(int row, int size) {
        System.out.printf("%2d |", row); // Print the row number

        for (int i = 1; i <= size; i++) {
            int result = row * i;
            System.out.printf("%5d", result);
            if (i != size) {
                System.out.print("  |");
            }
        }
        System.out.println(); // New line after the row
    }

    public static void printLine(int size) {
        System.out.print("   |");
        for (int i =1; i <= size; i++) {
            System.out.print("-------+");
        }
        System.out.println();
    }
}