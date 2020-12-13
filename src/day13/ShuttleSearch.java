package day13;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ShuttleSearch {
    public int partOne(String input) {
        String[] lines = input.split("\n");
        int earliestTimestampToDepart = Integer.parseInt(lines[0]);

        List<Integer> departureTimes = Arrays.stream(lines[1].split(","))
                .filter(s -> !s.equals("x"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int minWaitingTime = Integer.MAX_VALUE;
        int idOfEarliestBus = departureTimes.get(0);

        for (Integer departureTime : departureTimes) {
            int waitTime = departureTime - (earliestTimestampToDepart % departureTime);
            if (waitTime < minWaitingTime) {
                minWaitingTime = waitTime;
                idOfEarliestBus = departureTime;
            }
        }

        return idOfEarliestBus * minWaitingTime;
    }

    public long partTwo(String input) {
        Map<Integer, Integer> departureTimesWithWaitTime = new HashMap<>();

        String[] split = input.split(",");
        for (int waitTime = 0; waitTime < split.length; waitTime++) {
            String departureString = split[waitTime];
            if (!departureString.equals("x")) {
                departureTimesWithWaitTime.put(Integer.valueOf(departureString), waitTime);
            }
        }

        long multiplier = 1;
        long sum = 0;

        for (Map.Entry<Integer, Integer> entry : departureTimesWithWaitTime.entrySet()) {
            Integer departureTime = entry.getKey();
            Integer waitTime = entry.getValue();
            while ((sum + waitTime) % departureTime != 0) {
                sum += multiplier;
            }
            multiplier *= departureTime;
        }

        return sum;
    }
}
