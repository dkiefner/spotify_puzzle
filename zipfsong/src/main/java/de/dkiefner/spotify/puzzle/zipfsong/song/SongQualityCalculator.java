package de.dkiefner.spotify.puzzle.zipfsong.song;

import de.dkiefner.spotify.puzzle.zipfsong.reader.DataToAnalyze;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SongQualityCalculator {

    public List<String> calculate(DataToAnalyze dataToAnalyze) {

        List<Song> songs = dataToAnalyze.getSongs();
        int listenedSongCount = songs.size();
        for (int i = 0; i < listenedSongCount; i++) {
            Song currentSong = songs.get(i);

            float zipfsQuality = listenedSongCount - i;
            float quality = currentSong.getTimesListened() / zipfsQuality;
            currentSong.setQuality(quality);
        }

        return songs.stream()
                .sorted(new SongQualityComparator())
                .limit(dataToAnalyze.getNumberOfSongsToSelect())
                .map(Song::getName)
                .collect(Collectors.toList());
    }

    private class SongQualityComparator implements Comparator<Song> {
        @Override
        public int compare(Song a, Song b) {
            if (a.getQuality() == b.getQuality()) {
                return 0;
            }

            return a.getQuality() > b.getQuality() ? -1 : 1;
        }
    }
}
