package cz.upce.fei.zzapr.w03;


import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int minRange = 1;
        int maxRange = 100;
        int randomNumber = (int) (Math.random() * (maxRange - minRange + 1)) + minRange;
        int attempts = 0;
        boolean hasGuessedCorrectly = false;

        System.out.println("Welcome to the Guessing Game!");
        System.out.println("I've picked a number between " + minRange + " and " + maxRange + ". Try to guess it!");

        while (!hasGuessedCorrectly) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else if (guess > randomNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You've guessed the number " + randomNumber + " correctly in " + attempts + " attempts!");
                hasGuessedCorrectly = true;
            }
        }

        scanner.close();
    }
}