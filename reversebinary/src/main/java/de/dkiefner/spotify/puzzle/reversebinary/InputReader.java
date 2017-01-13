package de.dkiefner.spotify.puzzle.reversebinary;

import java.io.InputStream;
import java.util.Scanner;

public class InputReader {

    private static long MIN_VALUE = 1;
    private static long MAX_VALUE = 1000000000;

    public long read(InputStream inputStream) throws ReadInputException {
        Scanner scanner = new Scanner(inputStream);

        if (!scanner.hasNext()) {
            throw new ReadInputException("There was no input given.");
        }

        if (!scanner.hasNextLong()) {
            throw new ReadInputException("The input is not of type long.");
        }

        long input = scanner.nextLong();

        if (input < MIN_VALUE) {
            throw new ReadInputException(String.format("The input is below the minimum number of %d.", MIN_VALUE));
        }

        if (input > MAX_VALUE) {
            throw new ReadInputException(String.format("The input exceeds the maximum number of %d.", MAX_VALUE));
        }

        return input;
    }
}
