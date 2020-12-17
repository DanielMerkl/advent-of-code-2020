package day17;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConwayCubesTest {

    @Test
    void partOne_test() {
        ConwayCubes conwayCubes = new ConwayCubes(testInput, false);

        conwayCubes.simulateCycles(6);
        long result = conwayCubes.getNumberOfActiveCubes();

        assertEquals(112L, result);
    }

    @Test
    void partOne() {
        ConwayCubes conwayCubes = new ConwayCubes(Input.input, false);

        conwayCubes.simulateCycles(6);
        long result = conwayCubes.getNumberOfActiveCubes();

        assertEquals(322L, result);
    }

    @Test
    void partTwo_test() {
        ConwayCubes conwayCubes = new ConwayCubes(testInput, true);

        conwayCubes.simulateCycles(6);
        long result = conwayCubes.getNumberOfActiveCubes();

        assertEquals(848L, result);
    }

    @Test
    void partTwo() {
        ConwayCubes conwayCubes = new ConwayCubes(Input.input, true);

        conwayCubes.simulateCycles(6);
        long result = conwayCubes.getNumberOfActiveCubes();

        assertEquals(2000L, result);
    }


    private final String testInput = """
            .#.
            ..#
            ###""";
}
