package cz.upce.fei.zzapr.w05;

import java.util.Scanner;

public class ArraySum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of elements in the first array:");
        int n1 = scanner.nextInt();
        int[] array1 = new int[n1];

        System.out.println("Enter the elements of the first array:");
        for (int i = 0; i < n1; i++) {
            array1[i] = scanner.nextInt();
        }

        System.out.println("Enter the number of elements in the second array:");
        int n2 = scanner.nextInt();
        int[] array2 = new int[n2];

        System.out.println("Enter the elements of the second array:");
        for (int i = 0; i < n2; i++) {
            array2[i] = scanner.nextInt();
        }

        int[] sumResult = sumArrays(array1, array2);

        if (sumResult != null) {
            System.out.println("Sum of the arrays:");
            printArray(sumResult);
        } else {
            System.out.println("Arrays do not have the same length, cannot sum them.");
        }

        scanner.close();
    }

    public static int[] sumArrays(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return null;
        }

        int[] sum = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            sum[i] = arr1[i] + arr2[i];
        }
        return sum;
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
