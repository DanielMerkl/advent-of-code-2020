package day03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TobogganTrajectoryTest {

    @Test
    void numberOfTrees_test1() {
        TobogganTrajectory tobogganTrajectory = new TobogganTrajectory(testInput);

        int numberOfTrees = tobogganTrajectory.numberOfTrees(1, 1);

        assertEquals(2, numberOfTrees);
    }

    @Test
    void numberOfTrees_test2() {
        TobogganTrajectory tobogganTrajectory = new TobogganTrajectory(testInput);

        int numberOfTrees = tobogganTrajectory.numberOfTrees(3, 1);

        assertEquals(7, numberOfTrees);
    }

    @Test
    void numberOfTrees_test3() {
        TobogganTrajectory tobogganTrajectory = new TobogganTrajectory(testInput);

        int numberOfTrees = tobogganTrajectory.numberOfTrees(5, 1);

        assertEquals(3, numberOfTrees);
    }

    @Test
    void numberOfTrees_test4() {
        TobogganTrajectory tobogganTrajectory = new TobogganTrajectory(testInput);

        int numberOfTrees = tobogganTrajectory.numberOfTrees(7, 1);

        assertEquals(4, numberOfTrees);
    }

    @Test
    void numberOfTrees_test5() {
        TobogganTrajectory tobogganTrajectory = new TobogganTrajectory(testInput);

        int numberOfTrees = tobogganTrajectory.numberOfTrees(1, 2);

        assertEquals(2, numberOfTrees);
    }

    @Test
    void numberOfTrees() {
        TobogganTrajectory tobogganTrajectory = new TobogganTrajectory(Input.input);

        int numberOfTrees = tobogganTrajectory.numberOfTrees(3, 1);

        assertEquals(198, numberOfTrees);
    }

    @Test
    void secondPart_test() {
        TobogganTrajectory tobogganTrajectory = new TobogganTrajectory(testInput);

        int numberOfTrees = tobogganTrajectory.secondPart();

        assertEquals(336, numberOfTrees);
    }

    @Test
    void secondPart() {
        TobogganTrajectory tobogganTrajectory = new TobogganTrajectory(Input.input);

        int numberOfTrees = tobogganTrajectory.secondPart();

        assertEquals(0, numberOfTrees);
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
