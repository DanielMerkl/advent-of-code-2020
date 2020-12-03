package day03;

import java.util.List;
import java.util.stream.Collectors;

public class TobogganTrajectory {
    private final List<String> lines;

    public TobogganTrajectory(String input) {
        lines = input.lines()
                .collect(Collectors.toList());
    }

    public int numberOfTrees(int deltaX, int deltaY) {
        int x = 0;
        int y = 0;
        int numberOfEncounteredTrees = 0;

        while (y < lines.size()) {
            String currentLine = lines.get(y);
            char currentChar = currentLine.charAt(x);
            if (currentChar == '#') {
                numberOfEncounteredTrees++;
            }
            x = (x + deltaX) % lines.get(0)
                    .length();
            y += deltaY;
        }

        return numberOfEncounteredTrees;
    }

    public int secondPart() {
        int result = 1;

        result *= numberOfTrees(1, 1);
        result *= numberOfTrees(3, 1);
        result *= numberOfTrees(5, 1);
        result *= numberOfTrees(7, 1);
        result *= numberOfTrees(1, 2);

        return result;
    }
}
