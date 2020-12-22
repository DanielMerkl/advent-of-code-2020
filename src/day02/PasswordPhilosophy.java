package day02;

import java.util.List;
import java.util.stream.Collectors;

public class PasswordPhilosophy {
    private final List<PasswordWithPhilosophy> passwordWithPhilosophies;

    public PasswordPhilosophy(String input) {
        passwordWithPhilosophies = input.lines()
                .map(PasswordWithPhilosophy::new)
                .collect(Collectors.toList());
    }

    public int numberOfValidPasswords() {
        return (int) passwordWithPhilosophies.stream()
                .filter(PasswordWithPhilosophy::hasRequiredNumberOfOccurrences)
                .count();
    }

    public int numberOfValidPasswords2() {
        return (int) passwordWithPhilosophies.stream()
                .filter(PasswordWithPhilosophy::hasLettersAtRequiredPositions)
                .count();
    }
}
