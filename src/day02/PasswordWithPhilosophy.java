package day02;

public class PasswordWithPhilosophy {
    private final String password;
    private final Philosophy philosophy;

    private PasswordWithPhilosophy(String password, Philosophy philosophy) {
        this.password = password;
        this.philosophy = philosophy;
    }

    public static PasswordWithPhilosophy fromInput(String input) {
        String[] split = input.split(": ");
        String password = split[1];
        Philosophy philosophy = Philosophy.fromInput(split[0]);

        return new PasswordWithPhilosophy(password, philosophy);
    }

    public boolean hasRequiredNumberOfOccurrences() {
        long count = password.chars()
                .filter(c -> c == philosophy.getLetter())
                .count();

        int min = philosophy.getFirst();
        int max = philosophy.getSecond();

        return count >= min && count <= max;
    }

    public boolean hasLettersAtRequiredPositions() {
        int i = philosophy.getFirst();
        int j = philosophy.getSecond();

        return password.charAt(i - 1) == philosophy.getLetter() ^
                password.charAt(j - 1) == philosophy.getLetter();
    }

    public String getPassword() {
        return password;
    }
}
