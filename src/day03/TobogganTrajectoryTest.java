package day03;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TobogganTrajectoryTest {

    @ParameterizedTest
    @MethodSource("getSlopes")
    void numberOfEncounteredTrees_test(int deltaX, int deltaY, int expected) {
        TobogganTrajectory tobogganTrajectory = new TobogganTrajectory(testInput);

        int numberOfEncounteredTrees = tobogganTrajectory.numberOfEncounteredTrees(deltaX, deltaY);

        assertEquals(expected, numberOfEncounteredTrees);
    }

    private static Stream<Arguments> getSlopes() {
        return Stream.of(
                Arguments.of(1, 1, 2),
                Arguments.of(3, 1, 7),
                Arguments.of(5, 1, 3),
                Arguments.of(7, 1, 4),
                Arguments.of(1, 2, 2)
        );
    }

    @Test
    void numberOfEncounteredTrees() {
        TobogganTrajectory tobogganTrajectory = new TobogganTrajectory(Input.input);

        int numberOfEncounteredTrees = tobogganTrajectory.numberOfEncounteredTrees(3, 1);

        assertEquals(198, numberOfEncounteredTrees);
    }

    @Test
    void secondPart_test() {
        TobogganTrajectory tobogganTrajectory = new TobogganTrajectory(testInput);

        long numberOfEncounteredTrees = tobogganTrajectory.secondPart();

        assertEquals(336, numberOfEncounteredTrees);
    }

    @Test
    void secondPart() {
        TobogganTrajectory tobogganTrajectory = new TobogganTrajectory(Input.input);

        long numberOfEncounteredTrees = tobogganTrajectory.secondPart();

        assertEquals(5140884672L, numberOfEncounteredTrees);
    }

    private final String testInput = """
            ..##.......
            #...#...#..
            .#....#..#.
            ..#.#...#.#
            .#...##..#.
            ..#.##.....
            .#.#.#....#
            .#........#
            #.##...#...
            #...##....#
            .#..#...#.#""";
}
