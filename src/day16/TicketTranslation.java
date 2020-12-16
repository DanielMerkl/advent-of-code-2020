package day16;

import java.util.*;
import java.util.stream.Collectors;

public class TicketTranslation {
    private final List<Rule> rules;
    private final Ticket myTicket;
    private final List<Ticket> nearbyTickets;

    public TicketTranslation(String input) {
        String[] split = input.split("\n\nyour ticket:\n");
        String ruleStrings = split[0];

        rules = ruleStrings.lines()
                .map(Rule::new)
                .collect(Collectors.toList());

        String[] split1 = split[1].split("\n\nnearby tickets:\n");

        myTicket = new Ticket(split1[0]);
        String nearbyTicketsString = split1[1];

        nearbyTickets = nearbyTicketsString.lines()
                .map(Ticket::new)
                .collect(Collectors.toList());
    }

    public long getErrorRate() {
        return nearbyTickets.stream()
                .map(this::getInvalidFieldsForTicket)
                .flatMap(List::stream)
                .reduce(0L, Long::sum);
    }

    private List<Long> getInvalidFieldsForTicket(Ticket ticket) {
        return ticket.getValues()
                .stream()
                .filter(this::isInvalidValue)
                .collect(Collectors.toList());
    }

    private boolean isInvalidValue(Long value) {
        return rules.stream().noneMatch(rule -> rule.matches(value));
    }

    public long partTwo() {
        Map<Rule, List<Integer>> rulesWithMatchingIndices = new HashMap<>();
        Map<String, Integer> descriptionIndices = new HashMap<>();

        discardAllInvalidTickets();

        for (Rule rule : rules) {
            List<Integer> indicesThatMatchRule = getIndicesForRule(rule);
            rulesWithMatchingIndices.put(rule, indicesThatMatchRule);
        }

        while (rulesWithMatchingIndices.size() > 0) {
            Map.Entry<Rule, List<Integer>> entryWithOnlyOnePossibleIndex = rulesWithMatchingIndices.entrySet()
                    .stream()
                    .filter(entry -> entry.getValue().size() == 1)
                    .findFirst()
                    .orElseThrow();

            Rule rule = entryWithOnlyOnePossibleIndex.getKey();
            List<Integer> indices = entryWithOnlyOnePossibleIndex.getValue();
            Integer onlyMatchingIndex = indices.get(0);

            descriptionIndices.put(rule.getDescription(), onlyMatchingIndex);

            rulesWithMatchingIndices.remove(rule);
            rulesWithMatchingIndices.forEach((_rule, matchingIndices) -> matchingIndices.remove(onlyMatchingIndex));
        }

        return descriptionIndices.entrySet()
                .stream()
                .filter(entry -> entry.getKey().startsWith("departure"))
                .map(entry -> myTicket.getValues().get(entry.getValue()))
                .reduce(1L, (a, b) -> a * b);
    }

    private void discardAllInvalidTickets() {
        nearbyTickets.removeIf(ticket -> {
            for (Long value : ticket.getValues()) {
                if (isInvalidValue(value)) {
                    return true;
                }
            }
            return false;
        });
    }

    private List<Integer> getIndicesForRule(Rule rule) {
        List<Integer> indicesThatMatchRule = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            if (allValuesMatchRule(rule, i)) {
                indicesThatMatchRule.add(i);
            }
        }

        return indicesThatMatchRule;
    }

    private boolean allValuesMatchRule(Rule rule, int i) {
        for (Ticket nearbyTicket : nearbyTickets) {
            List<Long> values = nearbyTicket.getValues();

            if (!rule.matches(values.get(i))) {
                return false;
            }
        }

        return true;
    }
}
