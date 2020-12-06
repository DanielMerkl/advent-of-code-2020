package day06;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CustomCustoms {
    private final List<Group> groups;

    public CustomCustoms(String input) {
        groups = Arrays.stream(input.split("\n\n"))
                .map(Group::new)
                .collect(Collectors.toList());
    }

    public int sumOfUniqueQuestionsPerGroup() {
        return groups.stream()
                .mapToInt(Group::getNumberOfUniqueQuestions)
                .sum();
    }

    public int sumOfQuestionsEveryPersonAnswered() {
        return groups.stream()
                .mapToInt(Group::getNumberQuestionsEveryPersonAnswered)
                .sum();
    }
}
