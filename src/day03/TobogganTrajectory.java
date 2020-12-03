package day03;

import java.util.List;
import java.util.stream.Collectors;

public class TobogganTrajectory {
    private final List<String> lines;

    public TobogganTrajectory(String input) {
        lines = input.lines()
                .collect(Collectors.toList());
    }

    public int numberOfEncounteredTrees(int deltaX, int deltaY) {
        int x = 0;
        int y = 0;
        int numberOfEncounteredTrees = 0;

        while (y < lines.size()) {
            String currentLine = lines.get(y);
            char currentChar = currentLine.charAt(x);
            if (currentChar == '#') {
                numberOfEncounteredTrees++;
            }
            x = (x + deltaX) % currentLine.length();
            y += deltaY;
        }

        return numberOfEncounteredTrees;
    }

    public long secondPart() {
        long result = 1;

        result *= numberOfEncounteredTrees(1, 1);
        result *= numberOfEncounteredTrees(3, 1);
        result *= numberOfEncounteredTrees(5, 1);
        result *= numberOfEncounteredTrees(7, 1);
        result *= numberOfEncounteredTrees(1, 2);

        return result;
    }
}
