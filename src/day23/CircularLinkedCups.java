package day23;

import java.util.*;

public class CircularLinkedCups {
    private Cup head = null;
    private Cup tail = null;
    private final Map<Long, Cup> cupsMap = new HashMap<>();

    public void addCup(long value) {
        Cup addedCup = new Cup(value);

        cupsMap.put(value, addedCup);

        if (head == null) {
            head = addedCup;
        } else {
            tail.setNext(addedCup);
        }

        tail = addedCup;
        tail.setNext(head);
    }

    public Cup getHead() {
        return head;
    }

    public List<Cup> remove3CupsClockwiseOfCurrentCup(Cup currentCup) {
        Cup first = currentCup.getNext();
        Cup second = first.getNext();
        Cup third = second.getNext();

        currentCup.setNext(third.getNext());

        return List.of(first, second, third);
    }

    public void insertAt(long insertionValue, List<Cup> cups) {
        Cup start = cupsMap.get(insertionValue);
        Cup end = start.getNext();

        Cup firstOfInsertedList = cups.get(0);
        Cup lastOfInsertedList = cups.get(cups.size() - 1);

        start.setNext(firstOfInsertedList);
        lastOfInsertedList.setNext(end);
    }

    public String getOrderAfterCupOne() {
        StringBuilder stringBuilder = new StringBuilder();

        Cup currentCup = cupsMap.get(1L);
        currentCup = currentCup.getNext();

        while (currentCup.getValue() != 1) {
            stringBuilder.append(currentCup.getValue());
            currentCup = currentCup.getNext();
        }

        return stringBuilder.toString();
    }

    public long multiplyNextTwoCupsAdjacentToCupWithValueOne() {
        Cup cupWithValueOne = cupsMap.get(1L);
        Cup first = cupWithValueOne.getNext();
        Cup second = first.getNext();
        return first.getValue() * second.getValue();
    }

    public int size() {
        return cupsMap.size();
    }
}
