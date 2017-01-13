package de.dkiefner.spotify.puzzle.zipfsong.reader;

import de.dkiefner.spotify.puzzle.zipfsong.song.Song;

import java.util.List;

public class DataToAnalyze {

    private int numberOfSongsToSelect;
    private List<Song> songs;

    public DataToAnalyze(int numberOfSongsToSelect, List<Song> songs) {
        this.numberOfSongsToSelect = numberOfSongsToSelect;
        this.songs = songs;
    }

    public int getNumberOfSongsToSelect() {
        return numberOfSongsToSelect;
    }

    public List<Song> getSongs() {
        return songs;
    }
}
