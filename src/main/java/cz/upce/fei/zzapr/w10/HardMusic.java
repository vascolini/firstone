package cz.upce.fei.zzapr.w10;

public class HardMusic extends Music{
    private String complexNotes;
    public HardMusic(String title, String artist, String complexNotes) {
        super(title, artist);
        this.complexNotes = complexNotes;
        this.level = 3;
    }
    @Override
    public String toString() {
        return getTitle() + " by " + getArtist() + " Complex Notes: " + complexNotes;
    }
}
