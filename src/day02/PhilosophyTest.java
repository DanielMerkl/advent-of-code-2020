package day02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhilosophyTest {
    @Test
    void parsesInputCorrectly() {
        Philosophy philosophy = new Philosophy("1-3 a");

        assertEquals(1, philosophy.getFirst());
        assertEquals(3, philosophy.getSecond());
        assertEquals('a', philosophy.getLetter());
    }
}
