package day02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordWithPhilosophyTest {

    @Test
    void parsesInputCorrectly() {
        PasswordWithPhilosophy passwordWithPhilosophy = new PasswordWithPhilosophy("1-3 a: abcde");

        String p = passwordWithPhilosophy.getPassword();

        assertEquals("abcde", p);
    }

    @Test
    void hasRequiredNumberOfOccurrences_true() {
        PasswordWithPhilosophy passwordWithPhilosophy = new PasswordWithPhilosophy("2-9 c: ccccccccc");

        boolean result = passwordWithPhilosophy.hasRequiredNumberOfOccurrences();

        assertTrue(result);
    }

    @Test
    void hasRequiredNumberOfOccurrences_false() {
        PasswordWithPhilosophy passwordWithPhilosophy = new PasswordWithPhilosophy("1-3 b: cdefg");

        boolean result = passwordWithPhilosophy.hasRequiredNumberOfOccurrences();

        assertFalse(result);
    }

    @Test
    void hasLettersAtRequiredPositions_true() {
        PasswordWithPhilosophy passwordWithPhilosophy = new PasswordWithPhilosophy("1-3 a: abcde");

        boolean result = passwordWithPhilosophy.hasLettersAtRequiredPositions();

        assertTrue(result);
    }

    @Test
    void hasLettersAtRequiredPositions_false() {
        PasswordWithPhilosophy passwordWithPhilosophy = new PasswordWithPhilosophy("2-9 c: ccccccccc");

        boolean result = passwordWithPhilosophy.hasLettersAtRequiredPositions();

        assertFalse(result);
    }
}
