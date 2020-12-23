package day23;

public class Cup {
    private final long value;
    private Cup next;

    public Cup(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    public Cup getNext() {
        return next;
    }

    public void setNext(Cup next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cup cup = (Cup) o;

        return value == cup.value;
    }

    @Override
    public int hashCode() {
        return (int) (value ^ (value >>> 32));
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
