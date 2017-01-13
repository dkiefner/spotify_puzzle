package de.dkiefner.spotify.puzzle.reversebinary;

public class Main {

    public static void main(String[] args) {
        InputReader inputReader = new InputReader();

        try {
            ReverseBinaryResolver reverseBinaryResolver = new ReverseBinaryResolver();
            long input = inputReader.read(System.in);
            long reversedBinaryNumber = reverseBinaryResolver.resolve(input);
            System.out.println(String.valueOf(reversedBinaryNumber));
        } catch (ReadInputException e) {
            System.err.println(e.getMessage());
        }
    }
}
