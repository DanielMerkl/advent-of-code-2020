package day08;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandheldHaltingTest {
    @Test
    void valueOfAccumulatorBeforeExecutingInstructionSecondTime_test() {
        HandheldHalting handheldHalting = new HandheldHalting(testInput);

        int result = handheldHalting.valueOfAccumulatorBeforeExecutingInstructionSecondTime();

        assertEquals(5, result);
    }

    @Test
    void valueOfAccumulatorBeforeExecutingInstructionSecondTime() {
        HandheldHalting handheldHalting = new HandheldHalting(Input.input);

        int result = handheldHalting.valueOfAccumulatorBeforeExecutingInstructionSecondTime();

        assertEquals(1134, result);
    }

    @Test
    void valueOfAccumulatorAfterProgramTerminates_test() {
        HandheldHalting handheldHalting = new HandheldHalting(testInput);

        int result = handheldHalting.valueOfAccumulatorAfterProgramTerminates();

        assertEquals(8, result);
    }

    @Test
    void valueOfAccumulatorAfterProgramTerminates() {
        HandheldHalting handheldHalting = new HandheldHalting(Input.input);

        int result = handheldHalting.valueOfAccumulatorAfterProgramTerminates();

        assertEquals(1205, result);
    }

    private final String testInput = """
            nop +0
            acc +1
            jmp +4
            acc +3
            jmp -3
            acc -99
            acc +1
            jmp -4
            acc +6""";
}
