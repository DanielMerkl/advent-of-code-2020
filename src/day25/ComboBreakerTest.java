package day25;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComboBreakerTest {

    @Test
    void calculateLoopSize_test1() {
        ComboBreaker comboBreaker = ComboBreaker.from(testInput);

        long result = comboBreaker.calculateLoopSize(5764801);

        assertEquals(8, result);
    }

    @Test
    void calculateLoopSize_test2() {
        ComboBreaker comboBreaker = ComboBreaker.from(testInput);

        long result = comboBreaker.calculateLoopSize(17807724);

        assertEquals(11, result);
    }

    @Test
    void partOne_test() {
        ComboBreaker comboBreaker = ComboBreaker.from(testInput);

        long result = comboBreaker.partOne();

        assertEquals(14897079, result);
    }

    @Test
    void partOne() {
        ComboBreaker comboBreaker = ComboBreaker.from(Input.input);

        long result = comboBreaker.partOne();

        assertEquals(42668, result);
    }

    private final String testInput = """
            5764801
            17807724""";

}
