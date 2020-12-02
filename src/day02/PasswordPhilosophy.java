package day02;

import java.util.List;
import java.util.stream.Collectors;

public class PasswordPhilosophy {
    private final List<Password> passwords;

    public PasswordPhilosophy(String input) {
        passwords = input.lines()
                .map(Password::new)
                .collect(Collectors.toList());
    }

    public int numberOfValidPasswords() {
        return (int) passwords.stream()
                .filter(Password::hasRequiredNumberOfOccurrences)
                .count();
    }

    public int numberOfValidPasswords2() {
        return (int) passwords.stream()
                .filter(Password::hasLettersAtRequiredPositions)
                .count();
    }
}
