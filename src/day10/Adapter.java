package day10;

public class Adapter implements Comparable<Adapter> {
    private final Integer joltage;

    public Adapter(Integer joltage) {
        this.joltage = joltage;
    }

    public int getJoltage() {
        return joltage;
    }

    public int joltageDelta(Adapter other) {
        return Math.abs(joltage - other.joltage);
    }

    @Override
    public int compareTo(Adapter other) {
        return joltage.compareTo(other.joltage);
    }
}
