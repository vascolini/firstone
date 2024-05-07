package cz.upce.fei.zzapr.w10;

import cz.upce.fei.zzapr.w10.exceptions.LevelErrors;

import java.util.Scanner;

public class Main {
//    enum Level {
//        NEW,
//        INTERMEDIATE,
//        EXPERT,
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Music Player App for Musicians!");
        System.out.println("Please choose your level of expertise:");
        System.out.println("1. New Player");
        System.out.println("2. Intermediate Player");
        System.out.println("3. Expert Player");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        try {
            Player firstplayer = new Player(choice);
            Music music1 = new EasyMusic("Happy Birthday", "Patty Hill");
            firstplayer.addMusic(music1);
            Music music2 = new IntermediateMusic("Let It Be", "The Beatles", "C G Am F, C G F C, C G Am F," +
                    "C G F C, Am G F C, F C G C");
            firstplayer.addMusic(music2);
            Music music3 = new HardMusic("Black Bird", "The Beatles", "G Am7 G/B C G, G Am7 G/B C G, " +
                    "C G/B Am7 C G/B Am7, Em7 A7 G B7 Em7 A7 G C Cm G");
            firstplayer.addMusic(music3);

            firstplayer.showmusic();
        } catch (LevelErrors e){
            System.out.println("Exception caught: " + e.getMessage());
        }

        scanner.close();
    }
}
