package de.dkiefner.spotify.puzzle.reversebinary;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class ReverseBinaryResolverTest {

    private ReverseBinaryResolver testee;

    @Before
    public void setup() {
        testee = new ReverseBinaryResolver();
    }

    @Test
    public void That_resolve_sample_1_works() {
        // given
        long input = 13;
        long expectedOutput = 11;

        // when
        final long result = testee.resolve(input);

        // then
        assertThat(result).isEqualTo(expectedOutput);
    }

    @Test
    public void That_resolve_sample_2_works() {
        // given
        long input = 47;
        long expectedOutput = 61;

        // when
        final long result = testee.resolve(input);

        // then
        assertThat(result).isEqualTo(expectedOutput);
    }

    @Test
    public void That_resolve_with_max_value_works() {
        // given
        long input = 1000000000;
        long expectedOutput = 1365623;

        // when
        final long result = testee.resolve(input);

        // then
        assertThat(result).isEqualTo(expectedOutput);
    }

    @Test
    public void That_resolve_with_min_value_works() {
        // given
        long input = 1;
        long expectedOutput = 1;

        // when
        final long result = testee.resolve(input);

        // then
        assertThat(result).isEqualTo(expectedOutput);
    }
}