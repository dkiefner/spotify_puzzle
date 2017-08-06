package de.dkiefner.spotify.puzzle.catvsdog.voting;

import de.dkiefner.spotify.puzzle.catvsdog.pet.Cat;
import de.dkiefner.spotify.puzzle.catvsdog.pet.Dog;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class MaxViewerCalculatorTest {

    private MaxViewerCalculator testee;

    @Before
    public void setup() {
        testee = new MaxViewerCalculator();
    }

    @Test
    public void That_spotify_sample_works() {
        // given
        int expectedMaxSatisfiedVotersCase1 = 1;
        int expectedMaxSatisfiedVotersCase2 = 3;

        List<VotingTestCase> votingTestCases = new ArrayList<>();

        Cat cat1 = new Cat(1);
        Dog dog1 = new Dog(1);
        VotingTestCase votingTestCase1 = new VotingTestCase(Arrays.asList(
                new Vote(cat1, dog1),
                new Vote(dog1, cat1)));
        votingTestCases.add(votingTestCase1);

        Dog dog2 = new Dog(2);
        VotingTestCase votingTestCase2 = new VotingTestCase(Arrays.asList(
                new Vote(cat1, dog1),
                new Vote(cat1, dog1),
                new Vote(cat1, dog2),
                new Vote(dog2, cat1)));
        votingTestCases.add(votingTestCase2);

        // when
        List<Integer> result = testee.calculate(votingTestCases);

        // then
        assertThat(result).containsExactly(expectedMaxSatisfiedVotersCase1, expectedMaxSatisfiedVotersCase2);
    }

    @Test
    public void That_own_sample_works() {
        // given
        int expectedMaxSatisfiedVotersCase = 9;

        List<VotingTestCase> votingTestCases = new ArrayList<>();

        Cat cat1 = new Cat(1);
        Cat cat2 = new Cat(2);
        Dog dog1 = new Dog(1);
        Dog dog2 = new Dog(2);
        Dog dog3 = new Dog(3);

        VotingTestCase votingTestCase = new VotingTestCase(Arrays.asList(
                new Vote(cat1, dog1),
                new Vote(cat2, dog3),
                new Vote(cat1, dog2),
                new Vote(cat1, dog1),
                new Vote(cat2, dog2),
                new Vote(cat2, dog1),
                new Vote(cat1, dog3),
                new Vote(cat2, dog1),
                new Vote(cat1, dog2),

                new Vote(dog3, cat2),
                new Vote(dog1, cat1),
                new Vote(dog1, cat1),
                new Vote(dog3, cat2),
                new Vote(dog1, cat2),
                new Vote(dog3, cat1),
                new Vote(dog3, cat1),
                new Vote(dog2, cat2)));
        votingTestCases.add(votingTestCase);

        // when
        List<Integer> result = testee.calculate(votingTestCases);

        // then
        assertThat(result).containsExactly(expectedMaxSatisfiedVotersCase);
    }

}