package day24;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TilePathTest {

    @Test
    void initializesCorrectly() {
        TilePath tilePath = TilePath.from("esew");

        List<Direction> result = tilePath.getDirections();

        List<Direction> expected = List.of(
                Direction.EAST,
                Direction.SOUTHEAST,
                Direction.WEST
        );

        assertIterableEquals(expected, result);
    }

}
