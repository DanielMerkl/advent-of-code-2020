package day19;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MonsterMessage {
    private final Map<String, String> rules = new HashMap<>();
    private final List<String> messages;
    public static final int REQUIRED_DEPTH = 12; // found threshold by trial and error

    public MonsterMessage(String input) {
        String[] split = input.split("\n\n");

        String rulesSection = split[0];
        for (String line : rulesSection.split("\n")) {
            String[] keyValue = line.split(": ");
            rules.put(keyValue[0], keyValue[1]);
        }

        String messagesSection = split[1];
        messages = messagesSection.lines()
                .collect(Collectors.toList());
    }

    public long partOne() {
        String regex = generateRegex();

        return messages.stream()
                .filter(message -> message.matches(regex))
                .count();
    }

    private String generateRegex() {
        for (Map.Entry<String, String> rule : rules.entrySet()) {
            String regexForValue = buildRegexRecursively(rule.getValue(), 0);
            rule.setValue(regexForValue);
        }

        return rules.get("0");
    }

    private String buildRegexRecursively(String s, int depth) {
        if (depth > REQUIRED_DEPTH) return ""; // prevents infinite deep nesting

        List<String> elements = Arrays.asList(s.split(" "));
        for (int i = 0; i < elements.size(); i++) {
            String element = elements.get(i);
            boolean isDigit = element.matches("^[0-9]+");
            if (isDigit) {
                String updatedRegex = "(" + buildRegexRecursively(rules.get(element), depth + 1) + ")";
                updatedRegex = updatedRegex.replaceAll("\"", "");
                elements.set(i, updatedRegex);
            }
        }

        return String.join("", elements);
    }

    public long partTwo() {
        rules.put("8", "42 | 42 8");
        rules.put("11", "42 31 | 42 11 31");

        String regex = generateRegex();

        return messages.stream()
                .filter(message -> message.matches(regex))
                .count();
    }
}
