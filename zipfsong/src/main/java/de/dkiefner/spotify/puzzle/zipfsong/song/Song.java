package de.dkiefner.spotify.puzzle.zipfsong.song;

public class Song {

    private long timesListened;
    private String name;
    private float quality;

    public Song(long timesListened, String name) {
        this.timesListened = timesListened;
        this.name = name;
    }

    public long getTimesListened() {
        return timesListened;
    }

    public String getName() {
        return name;
    }

    public float getQuality() {
        return quality;
    }

    public void setQuality(float quality) {
        this.quality = quality;
    }

    @Override
    public String toString() {
        return String.format("%d %s", timesListened, name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Song that = (Song) o;

        if (timesListened != that.timesListened) return false;
        return name.equals(that.name);

    }

    @Override
    public int hashCode() {
        int result = (int) (timesListened ^ (timesListened >>> 32));
        result = 31 * result + name.hashCode();
        return result;
    }
}
