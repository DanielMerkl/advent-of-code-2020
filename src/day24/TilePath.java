package day24;

import java.util.ArrayList;
import java.util.List;

class TilePath {
    private final List<Direction> directions;

    private TilePath(List<Direction> directions) {
        this.directions = directions;
    }

    static TilePath from(String input) {
        List<Direction> directions = new ArrayList<>();

        for (int i = 0; i < input.toCharArray().length; i++) {
            char c = input.charAt(i);

            Direction direction = switch (c) {
                case 's' -> {
                    i++;
                    char secondChar = input.charAt(i);
                    yield switch (secondChar) {
                        case 'e' -> Direction.SOUTHEAST;
                        case 'w' -> Direction.SOUTHWEST;
                        default -> throw new RuntimeException("Unexpected character: " + secondChar);
                    };
                }
                case 'n' -> {
                    i++;
                    char secondChar = input.charAt(i);
                    yield switch (secondChar) {
                        case 'e' -> Direction.NORTHEAST;
                        case 'w' -> Direction.NORTHWEST;
                        default -> throw new RuntimeException("Unexpected character: " + secondChar);
                    };
                }
                case 'e' -> Direction.EAST;
                case 'w' -> Direction.WEST;
                default -> throw new RuntimeException("Unexpected character: " + c);
            };

            directions.add(direction);
        }

        return new TilePath(directions);
    }

    List<Direction> getDirections() {
        return directions;
    }
}
