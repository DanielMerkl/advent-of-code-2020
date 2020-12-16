package day16;

public class Rule {
    private final String description;
    private final Range firstRange;
    private final Range secondRange;

    public Rule(String input) {
        String[] split = input.split(": ");
        description = split[0];

        String[] split1 = split[1].split(" or ");
        firstRange = new Range(split1[0]);
        secondRange = new Range(split1[1]);
    }


    public boolean matches(Long value) {
        return firstRange.includes(value) || secondRange.includes(value);
    }

    public String getDescription() {
        return description;
    }
}
