package day24;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

class Tile {
    private final long x;
    private final long y;

    Tile(long x, long y) {
        this.x = x;
        this.y = y;
    }

    Tile getAdjacentTile(Direction direction) {
        return switch (direction) {
            case EAST -> new Tile(x + 2, y);
            case SOUTHEAST -> new Tile(x + 1, y - 1);
            case SOUTHWEST -> new Tile(x - 1, y - 1);
            case WEST -> new Tile(x - 2, y);
            case NORTHWEST -> new Tile(x - 1, y + 1);
            case NORTHEAST -> new Tile(x + 1, y + 1);
        };
    }

    Set<Tile> getAllAdjacentTiles() {
        return Arrays.stream(Direction.values())
                .map(this::getAdjacentTile)
                .collect(Collectors.toSet());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tile tile = (Tile) o;

        if (x != tile.x) return false;
        return y == tile.y;
    }

    @Override
    public int hashCode() {
        int result = (int) (x ^ (x >>> 32));
        result = 31 * result + (int) (y ^ (y >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "(%s, %s)".formatted(x, y);
    }
}
