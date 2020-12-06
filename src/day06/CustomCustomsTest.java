package day06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomCustomsTest {

    @Test
    void sumOfUniqueQuestionsPerGroup_test() {
        CustomCustoms customCustoms = new CustomCustoms(testInput);

        int result = customCustoms.sumOfUniqueQuestionsPerGroup();

        assertEquals(11, result);
    }

    @Test
    void sumOfUniqueQuestionsPerGroup() {
        CustomCustoms customCustoms = new CustomCustoms(Input.input);

        int result = customCustoms.sumOfUniqueQuestionsPerGroup();

        assertEquals(6335, result);
    }

    @Test
    void sumOfQuestionsEveryPersonAnswered_test() {
        CustomCustoms customCustoms = new CustomCustoms(testInput);

        int result = customCustoms.sumOfQuestionsEveryPersonAnswered();

        assertEquals(6, result);
    }

    @Test
    void sumOfQuestionsEveryPersonAnswered() {
        CustomCustoms customCustoms = new CustomCustoms(Input.input);

        int result = customCustoms.sumOfQuestionsEveryPersonAnswered();

        assertEquals(3392, result);
    }

    private final String testInput = """
            abc
                        
            a
            b
            c
                        
            ab
            ac
                        
            a
            a
            a
            a
                        
            b""";

}
