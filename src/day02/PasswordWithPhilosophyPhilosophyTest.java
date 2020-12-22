package day02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordWithPhilosophyPhilosophyTest {

    @Test
    void numberOfValidPasswords_test() {
        PasswordPhilosophy passwordPhilosophy = new PasswordPhilosophy(testInput);

        int numberOfValidPasswords = passwordPhilosophy.numberOfValidPasswords();

        assertEquals(2, numberOfValidPasswords);
    }

    @Test
    void numberOfValidPasswords() {
        PasswordPhilosophy passwordPhilosophy = new PasswordPhilosophy(Input.input);

        int numberOfValidPasswords = passwordPhilosophy.numberOfValidPasswords();

        assertEquals(474, numberOfValidPasswords);
    }

    @Test
    void numberOfValidPasswords2_test() {
        PasswordPhilosophy passwordPhilosophy = new PasswordPhilosophy(testInput);

        int numberOfValidPasswords = passwordPhilosophy.numberOfValidPasswords2();

        assertEquals(1, numberOfValidPasswords);
    }

    @Test
    void numberOfValidPasswords2() {
        PasswordPhilosophy passwordPhilosophy = new PasswordPhilosophy(Input.input);

        int numberOfValidPasswords = passwordPhilosophy.numberOfValidPasswords2();

        assertEquals(745, numberOfValidPasswords);
    }

    private final String testInput = """
            1-3 a: abcde
            1-3 b: cdefg
            2-9 c: ccccccccc""";
}
