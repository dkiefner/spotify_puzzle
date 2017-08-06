package de.dkiefner.spotify.puzzle.catvsdog.pet;

public abstract class Pet {

    private int number;

    public Pet(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pet pet = (Pet) o;

        return number == pet.number;

    }

    @Override
    public int hashCode() {
        return number;
    }
}
