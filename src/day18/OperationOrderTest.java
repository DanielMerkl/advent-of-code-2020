package day18;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class OperationOrderTest {

    @ParameterizedTest
    @MethodSource("getPartOneTestArguments")
    void partOne_test(String input, long expected) {
        OperationOrder operationOrder = new OperationOrder(input);

        long result = operationOrder.partOne();

        assertEquals(expected, result);
    }

    private static Stream<Arguments> getPartOneTestArguments() {
        return Stream.of(
                Arguments.of("2 * 3 + (4 * 5)", 26),
                Arguments.of("5 + (8 * 3 + 9 + 3 * 4 * 3)", 437),
                Arguments.of("5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))", 12240),
                Arguments.of("((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2", 13632)
        );
    }

    @Test
    void partOne() {
        OperationOrder operationOrder = new OperationOrder(Input.input);

        long result = operationOrder.partOne();

        assertEquals(30753705453324L, result);
    }

    @ParameterizedTest
    @MethodSource("getPartTwoTestArguments")
    void partTwo_test(String input, long expected) {
        OperationOrder operationOrder = new OperationOrder(input);

        long result = operationOrder.partTwo();

        assertEquals(expected, result);
    }

    private static Stream<Arguments> getPartTwoTestArguments() {
        return Stream.of(
                Arguments.of("1 + (2 * 3) + (4 * (5 + 6))", 51),
                Arguments.of("2 * 3 + (4 * 5)", 46),
                Arguments.of("5 + (8 * 3 + 9 + 3 * 4 * 3)", 1445),
                Arguments.of("5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))", 669060),
                Arguments.of("((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2", 23340)
        );
    }

    @Test
    void partTwo() {
        OperationOrder operationOrder = new OperationOrder(Input.input);

        long result = operationOrder.partTwo();

        assertEquals(244817530095503L, result);
    }

}
