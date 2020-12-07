package day07;

public class Bag {
    private final String color;

    public Bag(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bag bag = (Bag) o;

        return color.equals(bag.color);
    }

    @Override
    public int hashCode() {
        return color.hashCode();
    }
}
