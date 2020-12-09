package day09;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EncodingErrorTest {

    @Test
    void getFirstNumberThatIsNotSumOfTwoPreviousNumbers_test() {
        EncodingError encodingError = new EncodingError(testInput);

        long result = encodingError.getFirstNumberThatIsNotSumOfTwoPreviousNumbers(5);

        assertEquals(127, result);
    }

    @Test
    void getFirstNumberThatIsNotSumOfTwoPreviousNumbers() {
        EncodingError encodingError = new EncodingError(Input.input);

        long result = encodingError.getFirstNumberThatIsNotSumOfTwoPreviousNumbers(25);

        assertEquals(1309761972, result);
    }

    @Test
    void getEncryptionWeakness_test() {
        EncodingError encodingError = new EncodingError(testInput);

        long result = encodingError.getEncryptionWeakness(127);

        assertEquals(62, result);
    }

    @Test
    void getEncryptionWeakness() {
        EncodingError encodingError = new EncodingError(Input.input);

        long result = encodingError.getEncryptionWeakness(1309761972);

        assertEquals(177989832, result);
    }

    private final String testInput = """
            35
            20
            15
            25
            47
            40
            62
            55
            65
            95
            102
            117
            150
            182
            127
            219
            299
            277
            309
            576""";
}
