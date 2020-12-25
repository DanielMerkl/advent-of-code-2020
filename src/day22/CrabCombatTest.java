package day22;

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
    void partTwo_test() {
        CrabCombat crabCombat = CrabCombat.from(testInput);

        long result = crabCombat.partTwo();

        assertEquals(291, result);
    }

    @Test
    void partTwo() {
        CrabCombat crabCombat = CrabCombat.from(Input.input);

        long result = crabCombat.partTwo();

        assertEquals(29177, result);
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

    private final String testInput2 = """
            Player 1:
            43
            19
                        
            Player 2:
            2
            29
            14""";

}
