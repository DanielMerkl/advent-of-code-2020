package day23;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrabCupsTest {

    @Test
    void partOne_test_10Moves() {
        CrabCups crabCups = CrabCups.from(testInput);

        crabCups.simulateMoves(10);
        String result = crabCups.partOne();

        assertEquals("92658374", result);
    }

    @Test
    void partOne_test_100Moves() {
        CrabCups crabCups = CrabCups.from(testInput);

        crabCups.simulateMoves(100);
        String result = crabCups.partOne();

        assertEquals("67384529", result);
    }

    @Test
    void partOne() {
        CrabCups crabCups = CrabCups.from(Input.input);

        crabCups.simulateMoves(100);
        String result = crabCups.partOne();

        assertEquals("76952348", result);
    }

    @Test
    void partTwo_test() {
        CrabCups crabCups = CrabCups.from(testInput);

        crabCups.extendToOneMillionCups();
        crabCups.simulateMoves(10_000_000);
        long result = crabCups.partTwo();

        assertEquals(149245887792L, result);
    }

    @Test
    void partTwo() {
        CrabCups crabCups = CrabCups.from(Input.input);

        crabCups.extendToOneMillionCups();
        crabCups.simulateMoves(10_000_000);
        long result = crabCups.partTwo();

        assertEquals(72772522064L, result);
    }

    private final String testInput = "389125467";
}
