package day02;

public class Philosophy {
    private final int first;
    private final int second;
    private final char letter;

    public Philosophy(String input) {
        String[] split = input.split(" ");
        letter = split[1].charAt(0);
        String[] firstSecond = split[0].split("-");
        first = Integer.parseInt(firstSecond[0]);
        second = Integer.parseInt(firstSecond[1]);
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    public char getLetter() {
        return letter;
    }
}
