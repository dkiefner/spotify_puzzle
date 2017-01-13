package de.dkiefner.spotify.puzzle.zipfsong.song;

import de.dkiefner.spotify.puzzle.zipfsong.reader.DataToAnalyze;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class SongQualityCalculatorTest {

    private SongQualityCalculator testee;

    @Before
    public void setup() {
        testee = new SongQualityCalculator();
    }

    @Test
    public void That_sample_1_works() {
        // given
        String expectedSongFour = "four";
        String expectedSongTwo = "two";

        List<Song> songs = new ArrayList<>();
        songs.add(new Song(30, "one"));
        songs.add(new Song(30, expectedSongTwo));
        songs.add(new Song(15, "three"));
        songs.add(new Song(25, expectedSongFour));

        DataToAnalyze dataToAnalyze = new DataToAnalyze(2, songs);

        // when
        List<String> result = testee.calculate(dataToAnalyze);

        // then
        assertThat(result.get(0)).isEqualTo(expectedSongFour);
        assertThat(result.get(1)).isEqualTo(expectedSongTwo);
    }

    @Test
    public void That_sample_2_works() {
        // given
        String expectedSong192000 = "19_2000";
        String expectedSongClintEastwood = "clint_eastwood";
        String expectedSongTomorrowComesToday = "tomorrow_comes_today";

        List<Song> songs = new ArrayList<>();
        songs.add(new Song(197812, "re_hash"));
        songs.add(new Song(78906, "5_4"));
        songs.add(new Song(189518, expectedSongTomorrowComesToday));
        songs.add(new Song(39453, "new_genious"));
        songs.add(new Song(210492, expectedSongClintEastwood));
        songs.add(new Song(26302, "man_research"));
        songs.add(new Song(22544, "punk"));
        songs.add(new Song(19727, "sound_check"));
        songs.add(new Song(17535, "double_bass"));
        songs.add(new Song(18782, "rock_the_house"));
        songs.add(new Song(198189, expectedSong192000));
        songs.add(new Song(13151, "latin_simone"));
        songs.add(new Song(12139, "starshine"));
        songs.add(new Song(11272, "slow_country"));
        songs.add(new Song(10521, "m1_a1"));

        DataToAnalyze dataToAnalyze = new DataToAnalyze(3, songs);

        // when
        List<String> result = testee.calculate(dataToAnalyze);

        // then
        assertThat(result).containsExactly(expectedSong192000, expectedSongClintEastwood, expectedSongTomorrowComesToday);
    }

}