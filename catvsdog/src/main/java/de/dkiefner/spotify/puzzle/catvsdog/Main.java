package de.dkiefner.spotify.puzzle.catvsdog;

import de.dkiefner.spotify.puzzle.catvsdog.reader.InputReader;
import de.dkiefner.spotify.puzzle.catvsdog.reader.ReadInputException;
import de.dkiefner.spotify.puzzle.catvsdog.voting.MaxViewerCalculator;
import de.dkiefner.spotify.puzzle.catvsdog.voting.VotingTestCase;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        InputReader inputReader = new InputReader();

        try {
            MaxViewerCalculator maxViewerCalculator = new MaxViewerCalculator();
            List<VotingTestCase> votingTestCases = inputReader.read(System.in);
            List<Integer> maxPossibleSatisfiedVoters = maxViewerCalculator.calculate(votingTestCases);
            maxPossibleSatisfiedVoters.stream().map(String::valueOf).forEach(System.out::println);
        } catch (ReadInputException e) {
            System.err.println(e.getMessage());
        }
    }
}
