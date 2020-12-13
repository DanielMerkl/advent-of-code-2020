package day12;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class NavigationInstructionTest {

    @ParameterizedTest
    @MethodSource("getConstructorParameters")
    void initializesCorrectly(String input, Action expectedAction, int expectedValue) {
        NavigationInstruction navigationInstruction = new NavigationInstruction(input);

        Action action = navigationInstruction.getAction();
        int value = navigationInstruction.getValue();

        assertEquals(expectedAction, action);
        assertEquals(expectedValue, value);
    }

    private static Stream<Arguments> getConstructorParameters() {
        return Stream.of(
                Arguments.of("N1", Action.MOVE_NORTH, 1),
                Arguments.of("S2", Action.MOVE_SOUTH, 2),
                Arguments.of("E3", Action.MOVE_EAST, 3),
                Arguments.of("W4", Action.MOVE_WEST, 4),
                Arguments.of("L90", Action.TURN_LEFT, 90),
                Arguments.of("R270", Action.TURN_RIGHT, 270),
                Arguments.of("F7", Action.MOVE_FORWARD, 7)
        );
    }

    @Test()
    void throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new NavigationInstruction("X42");
        });
    }

}
