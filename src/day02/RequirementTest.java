package day02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RequirementTest {
    @Test
    void parsesInputCorrectly() {
        Requirement requirement = new Requirement("1-3 a");

        assertEquals(1, requirement.getFirst());
        assertEquals(3, requirement.getSecond());
        assertEquals('a', requirement.getLetter());
    }
}
