package de.dkiefner.spotify.puzzle.catvsdog.reader;

import de.dkiefner.spotify.puzzle.catvsdog.pet.Cat;
import de.dkiefner.spotify.puzzle.catvsdog.pet.Dog;
import de.dkiefner.spotify.puzzle.catvsdog.pet.Pet;
import de.dkiefner.spotify.puzzle.catvsdog.voting.Vote;
import de.dkiefner.spotify.puzzle.catvsdog.voting.VotingTestCase;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputReader {

    private static long MIN_CATS_AND_DOGS = 1;
    private static long MAX_CATS_AND_DOGS = 100;
    private static long MIN_VOTES = 0;
    private static long MAX_VOTES = 500;

    public List<VotingTestCase> read(InputStream inputStream) throws ReadInputException {
        Scanner scanner = new Scanner(inputStream);

        int numberOfTestCases = readAndCheckNumberOfTestCases(scanner);
        return readAndCheckVotingTestCases(scanner, numberOfTestCases);
    }

    private int readAndCheckNumberOfTestCases(Scanner scanner) {
        return scanner.nextInt();
    }

    private List<VotingTestCase> readAndCheckVotingTestCases(Scanner scanner, int numberOfTestCases) {
        List<VotingTestCase> votingTestCases = new ArrayList<>();
        while (scanner.hasNext()) {
            int numberOfCats = scanner.nextInt();
            int numberOfDogs = scanner.nextInt();
            int numberOfVotes = scanner.nextInt();

            List<Vote> votes = readAndCheckVotes(scanner, numberOfVotes);
            votingTestCases.add(new VotingTestCase(votes));

            if (votingTestCases.size() >= numberOfTestCases) {
                break;
            }
        }
        return votingTestCases;
    }

    private List<Vote> readAndCheckVotes(Scanner scanner, int numberOfVotes) {
        List<Vote> votes = new ArrayList<>(numberOfVotes);

        while (scanner.hasNext()) {
            String keep = scanner.next();
            String throwOut = scanner.next();

            Pet keepPet = parsePet(keep);
            Pet throwOutPet = parsePet(throwOut);
            votes.add(new Vote(keepPet, throwOutPet));

            if (votes.size() >= numberOfVotes) {
                break;
            }
        }

        return votes;
    }

    private Pet parsePet(String petAsString) {
        boolean isACat = petAsString.startsWith("C");
        int number = Integer.valueOf(petAsString.substring(1));

        return isACat ? new Cat(number) : new Dog(number);
    }

}
