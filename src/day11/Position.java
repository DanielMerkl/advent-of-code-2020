package day11;

public class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position getAdjacent(Direction direction) {
        int updatedX = x;
        int updatedY = y;

        switch (direction) {
            case TopLeft -> {
                updatedX--;
                updatedY--;
            }
            case Top -> updatedY--;
            case TopRight -> {
                updatedX++;
                updatedY--;
            }
            case Left -> updatedX--;
            case Right -> updatedX++;
            case BottomLeft -> {
                updatedX--;
                updatedY++;
            }
            case Bottom -> updatedY++;
            case BottomRight -> {
                updatedX++;
                updatedY++;
            }
        }

        return new Position(updatedX, updatedY);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position that = (Position) o;

        if (x != that.x) return false;
        return y == that.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
