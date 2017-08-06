package de.dkiefner.spotify.puzzle.catvsdog.voting;

import java.util.List;

public class VotingTestCase {

    private List<Vote> votes;

    public VotingTestCase(List<Vote> votes) {
        this.votes = votes;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VotingTestCase that = (VotingTestCase) o;

        return votes.equals(that.votes);

    }

    @Override
    public int hashCode() {
        return votes.hashCode();
    }
}
