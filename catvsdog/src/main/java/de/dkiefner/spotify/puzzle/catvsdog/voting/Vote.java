package de.dkiefner.spotify.puzzle.catvsdog.voting;

import de.dkiefner.spotify.puzzle.catvsdog.pet.Pet;

public class Vote {

    private Pet keep;
    private Pet throwOut;

    public Vote(Pet keep, Pet throwOut) {
        this.keep = keep;
        this.throwOut = throwOut;
    }

    public Pet getKeep() {
        return keep;
    }

    public Pet getThrowOut() {
        return throwOut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vote vote = (Vote) o;

        if (!keep.equals(vote.keep)) return false;
        return throwOut.equals(vote.throwOut);

    }

    @Override
    public int hashCode() {
        int result = keep.hashCode();
        result = 31 * result + throwOut.hashCode();
        return result;
    }
}
