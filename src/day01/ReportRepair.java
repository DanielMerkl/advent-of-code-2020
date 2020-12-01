package day01;

import java.util.List;
import java.util.stream.Collectors;

public class ReportRepair {
    private final List<Integer> entries;

    public ReportRepair(String input) {
        entries = input.lines()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int getChecksumForTwoEntries(int requiredSum) {
        for (int i = 0; i < entries.size(); i++) {
            Integer firstEntry = entries.get(i);
            for (int j = i + 1; j < entries.size(); j++) {
                Integer secondEntry = entries.get(j);
                if (firstEntry + secondEntry == requiredSum) {
                    return firstEntry * secondEntry;
                }
            }
        }

        throw new EntriesNotFoundException(requiredSum);
    }

    public int getChecksumForThreeEntries(int requiredSum) {
        for (int i = 0; i < entries.size(); i++) {
            Integer firstEntry = entries.get(i);
            for (int j = i + 1; j < entries.size(); j++) {
                Integer secondEntry = entries.get(j);
                for (int k = j + 1; k < entries.size(); k++) {
                    Integer thirdEntry = entries.get(k);
                    if (firstEntry + secondEntry + thirdEntry == requiredSum) {
                        return firstEntry * secondEntry * thirdEntry;
                    }
                }
            }
        }

        throw new EntriesNotFoundException(requiredSum);
    }
}
