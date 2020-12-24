package day24;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TileTest {

    @ParameterizedTest
    @MethodSource("getDirections")
    void move(Direction direction, Tile expected) {
        Tile tile = new Tile(0, 0);

        Tile result = tile.getAdjacentTile(direction);

        assertEquals(expected, result);
    }

    private static Stream<Arguments> getDirections() {
        return Stream.of(
                Arguments.of(Direction.EAST, new Tile(2, 0)),
                Arguments.of(Direction.SOUTHEAST, new Tile(1, -1)),
                Arguments.of(Direction.SOUTHWEST, new Tile(-1, -1)),
                Arguments.of(Direction.WEST, new Tile(-2, 0)),
                Arguments.of(Direction.NORTHWEST, new Tile(-1, 1)),
                Arguments.of(Direction.NORTHEAST, new Tile(1, 1))
        );
    }
}
