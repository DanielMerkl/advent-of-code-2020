package day12;

import java.util.List;
import java.util.stream.Collectors;

public class RainRisk {
    private final List<NavigationInstruction> navigationInstructions;

    public RainRisk(String input) {
        navigationInstructions = input.lines()
                .map(NavigationInstruction::new)
                .collect(Collectors.toList());
    }

    public long partOne() {
        Ship ship = new Ship();

        for (NavigationInstruction navigationInstruction : navigationInstructions) {
            int value = navigationInstruction.getValue();

            switch (navigationInstruction.getAction()) {
                case MOVE_NORTH -> ship.move(Orientation.NORTH, value);
                case MOVE_SOUTH -> ship.move(Orientation.SOUTH, value);
                case MOVE_EAST -> ship.move(Orientation.EAST, value);
                case MOVE_WEST -> ship.move(Orientation.WEST, value);
                case TURN_LEFT -> ship.turnLeft(value);
                case TURN_RIGHT -> ship.turnRight(value);
                case MOVE_FORWARD -> ship.moveForward(value);
            }
        }

        return ship.getManhattanDistanceFromStartingPoint();
    }

    public long partTwo() {
        Ship ship = new Ship();
        Waypoint waypoint = new Waypoint(10,1);

        for (NavigationInstruction navigationInstruction : navigationInstructions) {
            int value = navigationInstruction.getValue();

            switch (navigationInstruction.getAction()) {
                case MOVE_NORTH -> waypoint.move(Orientation.NORTH, value);
                case MOVE_SOUTH -> waypoint.move(Orientation.SOUTH, value);
                case MOVE_EAST -> waypoint.move(Orientation.EAST, value);
                case MOVE_WEST -> waypoint.move(Orientation.WEST, value);
                case TURN_LEFT -> waypoint.rotateLeft(value);
                case TURN_RIGHT -> waypoint.rotateRight(value);
                case MOVE_FORWARD -> ship.moveForward(value, waypoint);
            }
        }

        return ship.getManhattanDistanceFromStartingPoint();
    }
}
