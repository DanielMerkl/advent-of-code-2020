package day12;

public class NavigationInstruction {
    private final Action action;
    private final int value;

    public NavigationInstruction(String input) {
        char c = input.charAt(0);
        action = switch (c) {
            case 'N' -> Action.MOVE_NORTH;
            case 'S' -> Action.MOVE_SOUTH;
            case 'E' -> Action.MOVE_EAST;
            case 'W' -> Action.MOVE_WEST;
            case 'L' -> Action.TURN_LEFT;
            case 'R' -> Action.TURN_RIGHT;
            case 'F' -> Action.MOVE_FORWARD;
            default -> throw new IllegalArgumentException("Unexpected character: " + c);
        };
        value = Integer.parseInt(input.substring(1));
    }

    public Action getAction() {
        return action;
    }

    public int getValue() {
        return value;
    }
}
