package day12;

public class Ship {
    private int x = 0;
    private int y = 0;
    private Orientation orientation = Orientation.EAST;

    public void move(Orientation orientation, int distance) {
        switch (orientation) {
            case NORTH -> y += distance;
            case SOUTH -> y -= distance;
            case EAST -> x += distance;
            case WEST -> x -= distance;
        }
    }

    public void moveForward(int distance) {
        switch (orientation) {
            case NORTH -> y += distance;
            case SOUTH -> y -= distance;
            case EAST -> x += distance;
            case WEST -> x -= distance;
        }
    }

    public void moveForward(int distance, Waypoint waypoint) {
        x += waypoint.getX() * distance;
        y += waypoint.getY() * distance;
    }

    public void turnLeft(int degree) {
        turnRight(360 - degree);
    }

    public void turnRight(int degree) {
        int oldDegree = getDegreeOfOrientation();
        int updatedDegree = (oldDegree + degree) % 360;
        setOrientation(updatedDegree);
    }

    public int getManhattanDistanceFromStartingPoint() {
        return Math.abs(x) + Math.abs(y);
    }

    private int getDegreeOfOrientation() {
        return switch (orientation) {
            case NORTH -> 0;
            case EAST -> 90;
            case SOUTH -> 180;
            case WEST -> 270;
        };
    }

    private void setOrientation(int degreeOfOrientation) {
        orientation = switch (degreeOfOrientation) {
            case 0 -> Orientation.NORTH;
            case 90 -> Orientation.EAST;
            case 180 -> Orientation.SOUTH;
            case 270 -> Orientation.WEST;
            default -> throw new IllegalArgumentException("Unexpected degreeOfOrientation: " + degreeOfOrientation);
        };
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Orientation getOrientation() {
        return orientation;
    }
}
