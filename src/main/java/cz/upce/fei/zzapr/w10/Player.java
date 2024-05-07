package cz.upce.fei.zzapr.w10;

import cz.upce.fei.zzapr.w10.exceptions.LevelErrors;

import java.util.ArrayList;
public class Player {
    private int level;
    public final int MAX_MUSICS = 2;
    private ArrayList<Music> musics;
    public Player(int level) throws LevelErrors{
        if (level != 1 && level != 2 && level != 3) {
            throw new LevelErrors("User should enter numbers from 1 to 3.\n");
        }
        this.level = level;
        musics = new ArrayList<Music>();
    }

    private int musicCounter;
    public void addMusic(Music music) {
        if (music.getLevel() <= this.level) {
            musics.add(music);
        } else {
            System.out.println(" The level of the player doesn't reach the music level");
        }
    }
    public void showmusic () {
        for (Music i: musics) {
            System.out.println(i.toString());
        }
    }
}
