package de.dkiefner.spotify.puzzle.zipfsong.reader;

import de.dkiefner.spotify.puzzle.zipfsong.song.Song;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class InputReaderTest {

    private InputReader testee;

    @Before
    public void setup() {
        testee = new InputReader();
    }

    private InputStream getInputStream(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @Test
    public void That_one_song_in_album_and_one_song_selected_When_given() throws ReadInputException {
        // given
        int expectedSongsToSelect = 1;
        Song expectedSong = new Song(10, "SongA");

        // when
        final DataToAnalyze result = testee.read(getInputStream(String.format("1 %d\n%s", expectedSongsToSelect, expectedSong.toString())));

        // then
        assertThat(result.getNumberOfSongsToSelect()).isEqualTo(expectedSongsToSelect);
    }

    @Test
    public void That_one_song_is_in_list_When_number_in_album_is_one_and_selection_is_one() throws ReadInputException {
        // given
        Song expectedSong = new Song(10, "SongA");

        // when
        final DataToAnalyze result = testee.read(getInputStream(String.format("1 1\n%s", expectedSong.toString())));

        // then
        assertThat(result.getSongs()).containsExactly(expectedSong);
    }

    @Test
    public void That_two_songs_are_in_list_When_number_in_album_is_two_and_selection_is_two() throws ReadInputException {
        // given
        Song expectedSongA = new Song(10, "SongA");
        Song expectedSongB = new Song(5, "SongB");

        // when
        final DataToAnalyze result = testee.read(getInputStream(String.format("2 2\n%s\n%s", expectedSongA.toString(), expectedSongB.toString())));

        // then
        assertThat(result.getSongs()).containsExactly(expectedSongA, expectedSongB);
    }

    @Test
    public void That_three_songs_are_in_list_When_number_in_album_is_three_and_selection_is_two() throws ReadInputException {
        // given
        Song expectedSongA = new Song(10, "SongA");
        Song expectedSongB = new Song(5, "SongB");
        Song expectedSongC = new Song(1, "SongC");

        // when
        final DataToAnalyze result = testee.read(getInputStream(String.format("3 2\n%s\n%s\n%s", expectedSongA.toString(), expectedSongB.toString(), expectedSongC.toString())));

        // then
        assertThat(result.getSongs()).containsExactly(expectedSongA, expectedSongB, expectedSongC);
    }
}