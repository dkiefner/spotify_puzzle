package de.dkiefner.spotify.puzzle.zipfsong;

import de.dkiefner.spotify.puzzle.zipfsong.reader.DataToAnalyze;
import de.dkiefner.spotify.puzzle.zipfsong.reader.InputReader;
import de.dkiefner.spotify.puzzle.zipfsong.reader.ReadInputException;
import de.dkiefner.spotify.puzzle.zipfsong.song.SongQualityCalculator;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        InputReader inputReader = new InputReader();

        try {
            SongQualityCalculator songQualityCalculator = new SongQualityCalculator();
            DataToAnalyze dataToAnalyze = inputReader.read(System.in);
            List<String> highestQualitySongs = songQualityCalculator.calculate(dataToAnalyze);
            highestQualitySongs.forEach(System.out::println);
        } catch (ReadInputException e) {
            System.err.println(e.getMessage());
        }
    }
}
