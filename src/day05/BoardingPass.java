package day05;

public class BoardingPass {
    private final int id;
    private final int row;
    private final int column;

    public BoardingPass(String input) {
        String rowString = input.substring(0, 7);
        String columnString = input.substring(7);

        row = executeBinarySpacePartitioning(rowString, 127, 'F');
        column = executeBinarySpacePartitioning(columnString, 7, 'L');

        id = row * 8 + column;
    }

    private int executeBinarySpacePartitioning(String input, int upper, char lowerIndicator) {
        int lower = 0;

        for (char c : input.toCharArray()) {
            double mid = (lower + upper) / 2.0;
            if (c == lowerIndicator) {
                upper = (int) Math.floor(mid);
            } else {
                lower = (int) Math.ceil(mid);
            }
        }

        return upper;
    }

    public int getId() {
        return id;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
