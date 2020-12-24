package day22;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrabCombatTest {

    @Test
    void partOne_test() {
        CrabCombat crabCombat = CrabCombat.from(testInput);

        long result = crabCombat.partOne();

        assertEquals(306, result);
    }

    @Test
    void partOne() {
        CrabCombat crabCombat = CrabCombat.from(Input.input);

        long result = crabCombat.partOne();

        assertEquals(33403, result);
    }

    @Test
    @Disabled
    void partTwo_test() {
        CrabCombat crabCombat = CrabCombat.from(testInput);

        long result = crabCombat.partTwo();

        assertEquals(306, result);
    }

    @Test
    @Disabled
    void partTwo() {
        CrabCombat crabCombat = CrabCombat.from(Input.input);

        long result = crabCombat.partTwo();

        assertEquals(-1, result);
    }

    private final String testInput = """
            Player 1:
            9
            2
            6
            3
            1
                        
            Player 2:
            5
            8
            4
            7
            10""";

}
