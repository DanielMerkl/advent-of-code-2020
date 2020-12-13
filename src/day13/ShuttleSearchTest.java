package day13;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShuttleSearchTest {
    @Test
    void partOne_test() {
        String testInput = """
                939
                7,13,x,x,59,x,31,19""";
        ShuttleSearch shuttleSearch = new ShuttleSearch();

        int result = shuttleSearch.partOne(testInput);

        assertEquals(295, result);
    }

    @Test
    void partOne() {
        ShuttleSearch shuttleSearch = new ShuttleSearch();

        int result = shuttleSearch.partOne(Input.input);

        assertEquals(4938, result);
    }

    @ParameterizedTest
    @MethodSource("getInputs")
    void partTwo_test(String input, long expectedResult) {
        ShuttleSearch shuttleSearch = new ShuttleSearch();

        long result = shuttleSearch.partTwo(input);

        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> getInputs() {
        return Stream.of(
                Arguments.of("17,x,13,19", 3417),
                Arguments.of("7,13,x,x,59,x,31,19", 1068781),
                Arguments.of("67,7,59,61", 754018),
                Arguments.of("67,x,7,59,61", 779210),
                Arguments.of("67,7,x,59,61", 1261476),
                Arguments.of("1789,37,47,1889", 1202161486)
        );
    }

    @Test
    void partTwo() {
        ShuttleSearch shuttleSearch = new ShuttleSearch();

        long result = shuttleSearch.partTwo(Input.input.split("\n")[1]);

        assertEquals(230903629977901L, result);
    }
}
