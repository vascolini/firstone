package cz.upce.fei.zzapr.w10;

public class IntermediateMusic extends Music {

    private String chords;
    public IntermediateMusic(String title, String artist, String chords) {
        super(title, artist);
        this.chords = chords;
        this.level = 2;
    }
    @Override
    public String toString() {
        return getTitle() + " by " + getArtist() + " Chords: " + this.chords;
    }
}
