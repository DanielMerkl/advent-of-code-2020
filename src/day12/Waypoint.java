package day12;

public class Waypoint {
    private int x;
    private int y;

    public Waypoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(Orientation orientation, int distance) {
        switch (orientation) {
            case NORTH -> y += distance;
            case SOUTH -> y -= distance;
            case EAST -> x += distance;
            case WEST -> x -= distance;
        }
    }

    public void rotateLeft(int degree) {
        rotateRight(360 - degree);
    }

    public void rotateRight(int degree) {
        int prevX = x;
        int prevY = y;

        switch (degree) {
            case 90 -> {
                x = prevY;
                y = prevX * -1;
            }
            case 180 -> {
                x = prevX * -1;
                y = prevY * -1;
            }
            case 270 -> {
                x = prevY * -1;
                y = prevX;
            }
            default -> throw new IllegalArgumentException("Unexpected degree: " + degree);
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
