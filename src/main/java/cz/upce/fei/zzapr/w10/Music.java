package cz.upce.fei.zzapr.w10;

public class Music {
    private String title;
    private String artist;
    protected int level;

    public Music(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public int getLevel() {
        return level;
    }

    public String toString() {
        return getTitle() + " by " + getArtist();
    }
}
