package day06;

import java.util.*;
import java.util.stream.Collectors;

public class Group {
    private final List<Person> people;

    public Group(String input) {
        people = input.lines()
                .map(Person::new)
                .collect(Collectors.toList());
    }

    public int getNumberOfUniqueQuestions() {
        Set<Character> answers = new HashSet<>();

        for (Person person : people) {
            answers.addAll(person.getAnswers());
        }

        return answers.size();
    }

    public int getNumberQuestionsEveryPersonAnswered() {
        Map<Character, Integer> answerCounts = new HashMap<>();

        for (Person person : people) {
            for (Character answer : person.getAnswers()) {
                answerCounts.computeIfPresent(answer, (_c, count) -> count + 1);
                answerCounts.putIfAbsent(answer, 1);
            }
        }

        int numberQuestionsEveryPersonAnswered = 0;
        for (Integer count : answerCounts.values()) {
            boolean everyPersonAnseredCurrentQuestion = count == people.size();
            if (everyPersonAnseredCurrentQuestion) {
                numberQuestionsEveryPersonAnswered++;
            }
        }

        return numberQuestionsEveryPersonAnswered;
    }
}
