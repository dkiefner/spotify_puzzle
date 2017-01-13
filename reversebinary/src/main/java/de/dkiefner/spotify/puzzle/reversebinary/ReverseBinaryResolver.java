package de.dkiefner.spotify.puzzle.reversebinary;

public class ReverseBinaryResolver {

    public long resolve(long number) {
        String binary = convertDecimalToBinary(number);
        return convertBinaryReversedToDecimal(binary);
    }

    private String convertDecimalToBinary(long number) {
        String result = "";

        while (number > 0) {
            result = String.valueOf(number % 2) + result;
            number = number / 2;
        }

        return result;
    }

    private long convertBinaryReversedToDecimal(String binary) {
        long result = 0;
        for (int i = 0; i < binary.length(); i++) {
            double pow = Math.pow(2, i);
            Long digit = Long.valueOf(binary.substring(i, i + 1));
            result += pow * digit;
        }

        return result;
    }
}
