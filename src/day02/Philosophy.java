package day02;

public class Philosophy {
    private final int first;
    private final int second;
    private final char letter;

    private Philosophy(int first, int second, char letter) {
        this.first = first;
        this.second = second;
        this.letter = letter;
    }

    public static Philosophy fromInput(String input) {
        String[] split = input.split(" ");
        char letter = split[1].charAt(0);
        String[] firstSecond = split[0].split("-");
        int first = Integer.parseInt(firstSecond[0]);
        int second = Integer.parseInt(firstSecond[1]);
        return new Philosophy(first, second, letter);
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
