package cz.upce.fei.zzapr.w08;

// Music class (superclass)


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

// Example usage:
public class Main {
    public static void main(String[] args) {
        NewPlayer song1 = new NewPlayer("Wonderful Tonight", "Eric Clapton", true);
        IntermediatePlayer song2 = new IntermediatePlayer("All Along The Watchtower", "Jimi Hendrix", new String[]{"G", "D", "Am", "C"});
        ExpertPlayer song3 = new ExpertPlayer("Stairway to Heaven", "Led Zeppelin", new String[]{"Fmaj7", "Am7", "G6", "D9"});

        System.out.println(song1.play());
        System.out.println(song2.play());
        System.out.println(song3.play());
    }
}
