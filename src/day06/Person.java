package day06;

import java.util.HashSet;
import java.util.Set;

public class Person {
    private final Set<Character> answers = new HashSet<>();

    public Person(String input) {
        for (char c : input.toCharArray()) {
            answers.add(c);
        }
    }

    public Set<Character> getAnswers() {
        return answers;
    }
}
