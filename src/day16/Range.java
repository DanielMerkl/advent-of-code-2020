package day16;

public class Range {
    private final long start;
    private final long end;

    public Range(String input) {
        String[] split = input.split("-");
        start = Integer.parseInt(split[0]);
        end = Integer.parseInt(split[1]);
    }

    public boolean includes(Long value) {
        return value >= start && value <= end;
    }
}
