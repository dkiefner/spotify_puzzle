package de.dkiefner.spotify.puzzle.catvsdog.voting;


import de.dkiefner.spotify.puzzle.catvsdog.pet.Cat;

import java.util.ArrayList;
import java.util.List;

public class MaxViewerCalculator {

    public List<Integer> calculate(List<VotingTestCase> testCases) {
        List<Integer> result = new ArrayList<>();

        for (VotingTestCase testCase : testCases) {
            int numberOfSatisfiedCatLovers = 0;
            int numberOfSatisfiedDogLovers = 0;

            for (Vote vote : testCase.getVotes()) {
                if (vote.getKeep() instanceof Cat) {
                    numberOfSatisfiedCatLovers++;
                } else {
                    numberOfSatisfiedDogLovers++;
                }
            }

            result.add(Math.max(numberOfSatisfiedCatLovers, numberOfSatisfiedDogLovers));
        }
        return result;
    }
}
