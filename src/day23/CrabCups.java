package day23;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CrabCups {
    private final CircularLinkedCups cups;
    private Cup currentCup;

    public CrabCups(CircularLinkedCups cups, Cup currentCup) {
        this.cups = cups;
        this.currentCup = currentCup;
    }

    public static CrabCups from(String input) {
        CircularLinkedCups cups = new CircularLinkedCups();
        Arrays.stream(input.split(""))
                .map(Long::parseLong)
                .forEachOrdered(cups::addCup);
        Cup currentCup = cups.getHead();

        return new CrabCups(cups, currentCup);
    }

    public void simulateMoves(int n) {
        for (int move = 0; move < n; move++) {
            List<Cup> removedCups = cups.remove3CupsClockwiseOfCurrentCup(currentCup);
            long insertionValue = getNextInsertionValue(removedCups);
            cups.insertAt(insertionValue, removedCups);
            currentCup = currentCup.getNext();
        }
    }

    private long getNextInsertionValue(List<Cup> removedCups) {
        long insertionValue = currentCup.getValue();

        List<Long> removedCupsValues = removedCups.stream()
                .map(Cup::getValue)
                .collect(Collectors.toList());

        do {
            insertionValue--;
            if (insertionValue == 0) {
                insertionValue = cups.size();
            }
        } while (removedCupsValues.contains(insertionValue));

        return insertionValue;
    }

    public void extendToOneMillionCups() {
        IntStream
                .rangeClosed(cups.size() + 1, 1_000_000)
                .forEach(cups::addCup);
    }

    public String partOne() {
        return cups.getOrderAfterCupOne();
    }

    public long partTwo() {
        return cups.multiplyNextTwoCupsAdjacentToCupWithValueOne();
    }
}
