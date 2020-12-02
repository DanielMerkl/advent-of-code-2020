package day02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordTest {

    @Test
    void parsesInputCorrectly() {
        Password password = new Password("1-3 a: abcde");

        String p = password.getPassword();

        assertEquals("abcde", p);
    }

    @Test
    void hasRequiredNumberOfOccurrences_true() {
        Password password = new Password("2-9 c: ccccccccc");

        boolean result = password.hasRequiredNumberOfOccurrences();

        assertTrue(result);
    }

    @Test
    void hasRequiredNumberOfOccurrences_false() {
        Password password = new Password("1-3 b: cdefg");

        boolean result = password.hasRequiredNumberOfOccurrences();

        assertFalse(result);
    }

    @Test
    void hasLettersAtRequiredPositions_true() {
        Password password = new Password("1-3 a: abcde");

        boolean result = password.hasLettersAtRequiredPositions();

        assertTrue(result);
    }

    @Test
    void hasLettersAtRequiredPositions_false() {
        Password password = new Password("2-9 c: ccccccccc");

        boolean result = password.hasLettersAtRequiredPositions();

        assertFalse(result);
    }
}
