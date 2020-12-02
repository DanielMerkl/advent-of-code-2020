package day02;

public class Password {
    private final String password;
    private final Requirement requirement;

    public Password(String input) {
        String[] split = input.split(": ");
        password = split[1];
        requirement = new Requirement(split[0]);
    }

    public boolean hasRequiredNumberOfOccurrences() {
        long count = password.chars()
                .filter(c -> c == requirement.getLetter())
                .count();

        int min = requirement.getFirst();
        int max = requirement.getSecond();

        return count >= min && count <= max;
    }

    public boolean hasLettersAtRequiredPositions() {
        int i = requirement.getFirst();
        int j = requirement.getSecond();

        return password.charAt(i - 1) == requirement.getLetter() ^
                password.charAt(j - 1) == requirement.getLetter();
    }

    public String getPassword() {
        return password;
    }

    public Requirement getRequirement() {
        return requirement;
    }
}
