package day15;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RambunctiousRecitationTest {

    @ParameterizedTest
    @MethodSource("getStartingNumbers")
    void get2020thNumberSpoken_test(String input, long expectedResult) {
        RambunctiousRecitation rambunctiousRecitation = new RambunctiousRecitation(input);

        long result = rambunctiousRecitation.getNthNumberSpoken(2020);

        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> getStartingNumbers() {
        return Stream.of(
                Arguments.of("0,3,6", 436),
                Arguments.of("1,3,2", 1),
                Arguments.of("2,1,3", 10),
                Arguments.of("1,2,3", 27),
                Arguments.of("2,3,1", 78),
                Arguments.of("3,2,1", 438),
                Arguments.of("3,1,2", 1836)
        );
    }

    @Test
    void get2020thNumberSpoken() {
        RambunctiousRecitation rambunctiousRecitation = new RambunctiousRecitation(Input.input);

        long result = rambunctiousRecitation.getNthNumberSpoken(2020);

        assertEquals(1015, result);
    }

    @Test
    void get30000000thNumberSpoken() {
        RambunctiousRecitation rambunctiousRecitation = new RambunctiousRecitation(Input.input);

        long result = rambunctiousRecitation.getNthNumberSpoken(30000000);

        assertEquals(201, result);
    }

}
