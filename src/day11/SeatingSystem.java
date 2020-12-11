package day11;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class SeatingSystem {
    private Map<Position, Status> seats = new HashMap<>();
    private final EnumSet<Direction> directions = EnumSet.allOf(Direction.class);
    private final int yMax;
    private final int xMax;
    private boolean stabilized = false;

    public SeatingSystem(String input) {
        String[] lines = input.split("\n");

        yMax = lines.length;
        xMax = lines[0].length();

        for (int row = 0; row < lines.length; row++) {
            for (int column = 0; column < lines[row].length(); column++) {
                Position position = new Position(column, row);
                char c = lines[row].charAt(column);
                Status status = switch (c) {
                    case '.' -> Status.Floor;
                    case 'L' -> Status.Empty;
                    case '#' -> Status.Occupied;
                    default -> throw new RuntimeException("Illegal character: %s".formatted(c));
                };
                seats.put(position, status);
            }
        }
    }

    public int numberOfOccupiedSeats(int thresholdOfOccupiedSeats, boolean onlyNearby) {
        while (!stabilized) {
            simulateRound(thresholdOfOccupiedSeats, onlyNearby);
        }

        return getTotalNumberOfOccupiedSeats();
    }

    public void simulateRound(int thresholdOfOccupiedSeats, boolean onlyNearby) {
        Map<Position, Status> updatedGrid = new HashMap<>();

        boolean seatsChanged = false;

        for (Map.Entry<Position, Status> entry : seats.entrySet()) {
            Position position = entry.getKey();
            Status status = entry.getValue();
            int numberOfOccupiedSeats;
            if (onlyNearby) {
                numberOfOccupiedSeats = getNumberOfNearbyOccupiedSeats(position);
            } else {
                numberOfOccupiedSeats = getNumberOfOccupiedSeatsInSight(position);
            }
            if (status == Status.Empty && numberOfOccupiedSeats == 0) {
                updatedGrid.put(position, Status.Occupied);
                seatsChanged = true;
            } else if (status == Status.Occupied && numberOfOccupiedSeats >= thresholdOfOccupiedSeats) {
                updatedGrid.put(position, Status.Empty);
                seatsChanged = true;
            } else {
                updatedGrid.put(position, status);
            }
        }

        stabilized = !seatsChanged;
        seats = updatedGrid;
    }

    private int getNumberOfNearbyOccupiedSeats(Position position) {
        int numberOfNearbyOccupiedSeats = 0;

        for (Direction direction : directions) {
            Position adjacent = position.getAdjacent(direction);
            if (isInsideGrid(adjacent) && seats.get(adjacent) == Status.Occupied) {
                numberOfNearbyOccupiedSeats++;
            }
        }

        return numberOfNearbyOccupiedSeats;
    }

    private int getNumberOfOccupiedSeatsInSight(Position position) {
        int numberOfOccupiedSeatsInSight = 0;

        for (Direction direction : directions) {
            if (isOccupiedSeatInSight(position, direction)) {
                numberOfOccupiedSeatsInSight++;
            }
        }

        return numberOfOccupiedSeatsInSight;
    }

    private boolean isOccupiedSeatInSight(Position position, Direction direction) {
        Position adjacent = position.getAdjacent(direction);
        while (isInsideGrid(adjacent)) {
            if (seats.get(adjacent) == Status.Occupied) {
                return true;
            }
            if (seats.get(adjacent) == Status.Empty) {
                return false;
            }

            adjacent = adjacent.getAdjacent(direction);
        }

        return false;
    }

    private boolean isInsideGrid(Position position) {
        return position.getX() >= 0 && position.getX() < xMax &&
                position.getY() >= 0 && position.getY() < yMax;
    }

    private int getTotalNumberOfOccupiedSeats() {
        return (int) seats.values()
                .stream()
                .filter(status -> status == Status.Occupied)
                .count();
    }
}
