package day12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RainRiskTest {

    @Test
    void partOne_test() {
        RainRisk rainRisk = new RainRisk(testInput);

        long result = rainRisk.partOne();

        assertEquals(25, result);
    }

    @Test
    void partOne() {
        RainRisk rainRisk = new RainRisk(Input.input);

        long result = rainRisk.partOne();

        assertEquals(820, result);
    }

    @Test
    void partTwo_test() {
        RainRisk rainRisk = new RainRisk(testInput);

        long result = rainRisk.partTwo();

        assertEquals(286, result);
    }

    @Test
    void partTwo() {
        RainRisk rainRisk = new RainRisk(Input.input);

        long result = rainRisk.partTwo();

        assertEquals(66614, result);
    }

    private final String testInput = """
            F10
            N3
            F7
            R90
            F11""";

}
