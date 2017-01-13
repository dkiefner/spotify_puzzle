package de.dkiefner.spotify.puzzle.reversebinary;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.assertThatThrownBy;

public class InputReaderTest {

    private InputReader testee;

    @Before
    public void setup() {
        testee = new InputReader();
    }

    private InputStream getInputStream(long inputNumber) {
        String input = String.valueOf(inputNumber);
        return new ByteArrayInputStream(input.getBytes());
    }

    @Test
    public void That_input_is_valid_When_input_is_a_long() throws ReadInputException {
        // given
        long expectedInput = 10L;

        // when
        final long result = testee.read(getInputStream(expectedInput));

        // then
        assertThat(result).isEqualTo(expectedInput);
    }

    @Test
    public void That_input_is_valid_When_input_is_exact_lowest() throws ReadInputException {
        // given
        long expectedInput = 1L;

        // when
        final long result = testee.read(getInputStream(expectedInput));

        // then
        assertThat(result).isEqualTo(expectedInput);
    }

    @Test
    public void That_input_is_valid_When_input_is_exact_highest() throws ReadInputException {
        // given
        long expectedInput = 1000000000L;

        // when
        final long result = testee.read(getInputStream(expectedInput));

        // then
        assertThat(result).isEqualTo(expectedInput);
    }

    @Test
    public void That_input_is_not_valid_When_input_has_no_arguments() {
        // given
        InputStream inputStream = new ByteArrayInputStream("".getBytes());

        // when
        assertThatThrownBy(() -> testee.read(inputStream))
                .isInstanceOf(ReadInputException.class);
    }
}