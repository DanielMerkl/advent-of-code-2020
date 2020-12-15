package day15;

import java.util.*;

public class RambunctiousRecitation {
    private final Map<Long, ArrayList<Long>> numbersSpokenOnTurns = new HashMap<>();
    private Long currentTurn = 1L;
    private long lastSpokenNumber;

    public RambunctiousRecitation(String input) {
        Arrays.stream(input.split(","))
                .map(Long::parseLong)
                .forEach(number -> {
                    numbersSpokenOnTurns.put(number, new ArrayList<>(List.of(currentTurn)));
                    lastSpokenNumber = number;
                    currentTurn++;
                });
    }

    public long getNthNumberSpoken(int n) {
        for (long i = currentTurn; i <= n; i++) {
            List<Long> turnsLastSpokenNumberWasSpoken = numbersSpokenOnTurns.get(lastSpokenNumber);

            if (turnsLastSpokenNumberWasSpoken.size() == 1) {
                saveCurrentTurnForSpokenNumber(0L);
            } else {
                Long last = turnsLastSpokenNumberWasSpoken.get(turnsLastSpokenNumberWasSpoken.size() - 1);
                Long penultimate = turnsLastSpokenNumberWasSpoken.get(turnsLastSpokenNumberWasSpoken.size() - 2);
                long age = last - penultimate;
                saveCurrentTurnForSpokenNumber(age);
            }

            currentTurn++;
        }

        return lastSpokenNumber;
    }

    private void saveCurrentTurnForSpokenNumber(long spokenNumber) {
        numbersSpokenOnTurns.computeIfPresent(spokenNumber, (_number, spokenOnTurns) -> {
            spokenOnTurns.add(currentTurn);
            return spokenOnTurns;
        });
        numbersSpokenOnTurns.putIfAbsent(spokenNumber, new ArrayList<>(List.of(currentTurn)));
        lastSpokenNumber = spokenNumber;
    }
}
