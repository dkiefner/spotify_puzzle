package de.dkiefner.spotify.puzzle.catvsdog.reader;

import de.dkiefner.spotify.puzzle.catvsdog.pet.Cat;
import de.dkiefner.spotify.puzzle.catvsdog.pet.Dog;
import de.dkiefner.spotify.puzzle.catvsdog.voting.Vote;
import de.dkiefner.spotify.puzzle.catvsdog.voting.VotingTestCase;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
    public void That_one_test_case_with_one_cat_one_dog_and_one_vote_works() throws ReadInputException {
        // given
        Cat cat1 = new Cat(1);
        Dog dog1 = new Dog(1);
        Vote vote1 = new Vote(cat1, dog1);

        VotingTestCase expectedVotingTestCase = new VotingTestCase(Collections.singletonList(vote1));

        // when
        final List<VotingTestCase> result = testee.read(getInputStream("1\n1 1 1\nC1 D1"));

        // then
        assertThat(result).containsExactly(expectedVotingTestCase);
    }

    @Test
    public void That_one_test_case_with_two_cats_three_dogs_and_four_votes_works() throws ReadInputException {
        // given
        Cat cat1 = new Cat(1);
        Cat cat2 = new Cat(2);

        Dog dog1 = new Dog(1);
        Dog dog2 = new Dog(2);
        Dog dog3 = new Dog(3);

        Vote vote1 = new Vote(cat1, dog1);
        Vote vote2 = new Vote(cat2, dog2);
        Vote vote3 = new Vote(cat1, dog3);
        Vote vote4 = new Vote(cat2, dog1);

        VotingTestCase expectedVotingTestCase = new VotingTestCase(Arrays.asList(vote1, vote2, vote3, vote4));

        // when
        final List<VotingTestCase> result = testee.read(getInputStream("1\n2 3 4\nC1 D1\nC2 D2\nC1 D3\nC2 D1"));

        // then
        assertThat(result).containsExactly(expectedVotingTestCase);
    }

    @Test
    public void That_two_test_cases_with_each_one_cat_one_dog_and_one_vote_works() throws ReadInputException {
        // given
        Cat cat1 = new Cat(1);
        Dog dog1 = new Dog(1);
        Vote vote1 = new Vote(cat1, dog1);
        VotingTestCase expectedVotingTestCase1 = new VotingTestCase(Collections.singletonList(vote1));

        Cat cat2 = new Cat(2);
        Dog dog2 = new Dog(2);
        Vote vote2 = new Vote(cat2, dog2);
        VotingTestCase expectedVotingTestCase2 = new VotingTestCase(Collections.singletonList(vote2));

        // when
        final List<VotingTestCase> result = testee.read(getInputStream("2\n1 1 1\nC1 D1\n1 1 1\nC2 D2"));

        // then
        assertThat(result).containsExactly(expectedVotingTestCase1, expectedVotingTestCase2);
    }
}