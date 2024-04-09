package cz.upce.fei.zzapr.w09;

import java.util.Scanner;

// Music class (superclass)
class Music {
    private String title;
    private String artist;

    public Music(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    // Getters for title and artist
    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }
}

// NewPlayer class (subclass)
class NewPlayer extends Music {
    private boolean easyLevel;

    public NewPlayer(String title, String artist, boolean easyLevel) {
        super(title, artist);
        this.easyLevel = easyLevel;
    }

    public String play() {
        if (easyLevel) {
            return "Playing " + getTitle() + " by " + getArtist() + " (Easy level)";
        } else {
            return "Playing " + getTitle() + " by " + getArtist();
        }
    }
}

// IntermediatePlayer class (subclass)
class IntermediatePlayer extends Music {
    private String[] chords;

    public IntermediatePlayer(String title, String artist, String[] chords) {
        super(title, artist);
        this.chords = chords;
    }

    public String play() {
        return "Playing " + getTitle() + " by " + getArtist() + " (Chords: " + String.join(", ", chords) + ")";
    }
}

// ExpertPlayer class (subclass)
class ExpertPlayer extends Music {
    private String[] complexNotes;

    public ExpertPlayer(String title, String artist, String[] complexNotes) {
        super(title, artist);
        this.complexNotes = complexNotes;
    }

    public String play() {
        return "Playing " + getTitle() + " by " + getArtist() + " (Complex notes: " + String.join(", ", complexNotes) + ")";
    }
}

public class Main {
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

        switch (choice) {
            case 1:
                handleNewPlayer(scanner);
                break;
            case 2:
                handleIntermediatePlayer(scanner);
                break;
            case 3:
                handleExpertPlayer(scanner);
                break;
            default:
                System.out.println("Invalid choice. Exiting...");
        }

        scanner.close();
    }

    private static void handleNewPlayer(Scanner scanner) {
        System.out.print("Enter the title of the song: ");
        String title = scanner.nextLine();
        System.out.print("Enter the artist of the song: ");
        String artist = scanner.nextLine();
        System.out.print("Is it easy level? (true/false): ");
        boolean easyLevel = scanner.nextBoolean();

        NewPlayer song = new NewPlayer(title, artist, easyLevel);
        System.out.println(song.play());
    }

    private static void handleIntermediatePlayer(Scanner scanner) {
        System.out.print("Enter the title of the song: ");
        String title = scanner.nextLine();
        System.out.print("Enter the artist of the song: ");
        String artist = scanner.nextLine();
        System.out.print("Enter the chords (separated by comma): ");
        String[] chords = scanner.nextLine().split(",");

        IntermediatePlayer song = new IntermediatePlayer(title, artist, chords);
        System.out.println(song.play());
    }

    private static void handleExpertPlayer(Scanner scanner) {
        System.out.print("Enter the title of the song: ");
        String title = scanner.nextLine();
        System.out.print("Enter the artist of the song: ");
        String artist = scanner.nextLine();
        System.out.print("Enter the complex notes (separated by comma): ");
        String[] complexNotes = scanner.nextLine().split(",");

        ExpertPlayer song = new ExpertPlayer(title, artist, complexNotes);
        System.out.println(song.play());
    }
}
