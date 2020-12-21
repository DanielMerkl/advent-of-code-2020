package day21;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AllergenAssessmentTest {

    @Test
    void partOne_test() {
        AllergenAssessment allergenAssessment = new AllergenAssessment(testInput);

        long result = allergenAssessment.partOne();

        assertEquals(5, result);
    }

    @Test
    void partOne() {
        AllergenAssessment allergenAssessment = new AllergenAssessment(Input.input);

        long result = allergenAssessment.partOne();

        assertEquals(2211, result);
    }

    @Test
    void partTwo_test() {
        AllergenAssessment allergenAssessment = new AllergenAssessment(testInput);

        String result = allergenAssessment.partTwo();

        assertEquals("mxmxvkd,sqjhc,fvjkl", result);
    }

    @Test
    void partTwo() {
        AllergenAssessment allergenAssessment = new AllergenAssessment(Input.input);

        String result = allergenAssessment.partTwo();

        assertEquals("vv,nlxsmb,rnbhjk,bvnkk,ttxvphb,qmkz,trmzkcfg,jpvz", result);
    }

    private static final String testInput = """
            mxmxvkd kfcds sqjhc nhms (contains dairy, fish)
            trh fvjkl sbzzf mxmxvkd (contains dairy)
            sqjhc fvjkl (contains soy)
            sqjhc mxmxvkd sbzzf (contains fish)""";

}
