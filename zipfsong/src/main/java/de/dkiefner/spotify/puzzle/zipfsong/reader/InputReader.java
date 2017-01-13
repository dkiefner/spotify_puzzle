package de.dkiefner.spotify.puzzle.zipfsong.reader;

import de.dkiefner.spotify.puzzle.zipfsong.song.Song;

import java.io.InputStream;
import java.util.*;

public class InputReader {

    private static long MIN_SONGS_ON_THE_ALBUM = 1;
    private static long MAX_SONGS_ON_THE_ALBUM = 50000;
    private static long MIN_TIMES_SONG_LISTENED = 0;
    private static long MAX_TIMES_SONG_LISTENED = 1000000000000L;

    public DataToAnalyze read(InputStream inputStream) throws ReadInputException {
        Scanner scanner = new Scanner(inputStream);

        int numberOfSongsOnAlbum = readAndCheckNumberOfSongsOnAlbum(scanner);
        int numberOfSongsSelected = readAndCheckNumberOfSongsSelected(scanner, numberOfSongsOnAlbum);
        List<Song> songs = readAndCheckListenedSongs(scanner, numberOfSongsOnAlbum);

        return new DataToAnalyze(numberOfSongsSelected, songs);
    }

    private int readAndCheckNumberOfSongsOnAlbum(Scanner scanner) throws ReadInputException {
        if (!scanner.hasNextInt()) {
            throw new ReadInputException("There is no number of songs on album given.");
        }
        int numberOfSongs = scanner.nextInt();

        if (numberOfSongs < MIN_SONGS_ON_THE_ALBUM) {
            throw new ReadInputException(String.format("The number of songs on ablum is below the minimum number of %d.", MIN_SONGS_ON_THE_ALBUM));
        }

        if (numberOfSongs > MAX_SONGS_ON_THE_ALBUM) {
            throw new ReadInputException(String.format("The number of songs exceeds the maximum number of %d.", MAX_SONGS_ON_THE_ALBUM));
        }

        return numberOfSongs;
    }

    private int readAndCheckNumberOfSongsSelected(Scanner scanner, int numberOfSongsOnAlbum) throws ReadInputException {
        if (!scanner.hasNextInt()) {
            throw new ReadInputException("There is no number of selected songs given.");
        }
        int selectedSongs = scanner.nextInt();

        if (selectedSongs > numberOfSongsOnAlbum) {
            throw new ReadInputException(String.format("The selected number of songs cannot be more that number of songs on album (%d).", numberOfSongsOnAlbum));
        }

        return selectedSongs;
    }

    private List<Song> readAndCheckListenedSongs(Scanner scanner, int numberOfSongsOnAlbum) throws ReadInputException {
        List<Song> songs = new ArrayList<>();
        while (scanner.hasNext()) {
            long timesListened = readAndCheckTimesListened(scanner);
            String name = readAndCheckName(scanner);

            checkTimesListened(timesListened, name);

            songs.add(new Song(timesListened, name));

            if (songs.size() >= numberOfSongsOnAlbum) {
                break;
            }
        }
        return songs;
    }

    private long readAndCheckTimesListened(Scanner scanner) throws ReadInputException {
        if (!scanner.hasNextLong()) {
            throw new ReadInputException("There is no amount of listening of the song given.");
        }
        return scanner.nextLong();
    }

    private String readAndCheckName(Scanner scanner) throws ReadInputException {
        if (!scanner.hasNext()) {
            throw new ReadInputException("There is no name of of the song given.");
        }
        return scanner.next();
    }

    private void checkTimesListened(long timesListened, String name) throws ReadInputException {
        if (timesListened < MIN_TIMES_SONG_LISTENED) {
            throw new ReadInputException(String.format("The amount of listening the song <%s> is below the minimum number of %d.", name, MIN_TIMES_SONG_LISTENED));
        }

        if (timesListened > MAX_TIMES_SONG_LISTENED) {
            throw new ReadInputException(String.format("The amount of listening the song <%s> exceeds the maximum number of %d.", name, MAX_TIMES_SONG_LISTENED));
        }
    }
}
