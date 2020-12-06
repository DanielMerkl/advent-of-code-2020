package day06;

import java.util.List;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Group {
    private final List<Person> people;

    public Group(String input) {
        people = input.lines()
                .map(Person::new)
                .collect(Collectors.toList());
    }

    public int getNumberOfUniqueQuestions() {
        return (int) people.stream()
                .map(Person::getAnswers)
                .flatMap(Set::stream)
                .distinct()
                .count();
    }

    public int getNumberOfQuestionsEveryPersonAnswered() {
        BinaryOperator<Set<Character>> intersect = (set1, set2) -> {
            set1.retainAll(set2);
            return set1;
        };

        return people.stream()
                .map(Person::getAnswers)
                .reduce(intersect)
                .orElseThrow()
                .size();
    }
}
