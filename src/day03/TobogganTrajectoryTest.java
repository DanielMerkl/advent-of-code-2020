package day03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TobogganTrajectoryTest {

    @Test
    void numberOfEncounteredTrees_test1() {
        TobogganTrajectory tobogganTrajectory = new TobogganTrajectory(testInput);

        int numberOfEncounteredTrees = tobogganTrajectory.numberOfEncounteredTrees(1, 1);

        assertEquals(2, numberOfEncounteredTrees);
    }

    @Test
    void numberOfEncounteredTrees_test2() {
        TobogganTrajectory tobogganTrajectory = new TobogganTrajectory(testInput);

        int numberOfEncounteredTrees = tobogganTrajectory.numberOfEncounteredTrees(3, 1);

        assertEquals(7, numberOfEncounteredTrees);
    }

    @Test
    void numberOfEncounteredTrees_test3() {
        TobogganTrajectory tobogganTrajectory = new TobogganTrajectory(testInput);

        int numberOfEncounteredTrees = tobogganTrajectory.numberOfEncounteredTrees(5, 1);

        assertEquals(3, numberOfEncounteredTrees);
    }

    @Test
    void numberOfEncounteredTrees_test4() {
        TobogganTrajectory tobogganTrajectory = new TobogganTrajectory(testInput);

        int numberOfEncounteredTrees = tobogganTrajectory.numberOfEncounteredTrees(7, 1);

        assertEquals(4, numberOfEncounteredTrees);
    }

    @Test
    void numberOfEncounteredTrees_test5() {
        TobogganTrajectory tobogganTrajectory = new TobogganTrajectory(testInput);

        int numberOfEncounteredTrees = tobogganTrajectory.numberOfEncounteredTrees(1, 2);

        assertEquals(2, numberOfEncounteredTrees);
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
