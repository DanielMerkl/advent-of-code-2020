package day10;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AdapterArray {
    private final List<Adapter> adapters;
    private final Map<Integer, Long> memoizedNumberOfPossibleArrangements = new HashMap<>();

    public AdapterArray(String input) {
        adapters = input.lines()
                .map(Integer::valueOf)
                .map(Adapter::new)
                .sorted()
                .collect(Collectors.toList());
    }

    public int partOne() {
        return getNumberOfAdaptersWithJoltageDelta(1) * getNumberOfAdaptersWithJoltageDelta(3);
    }

    public int getNumberOfAdaptersWithJoltageDelta(int delta) {
        int result = 0;

        for (int i = 1; i < adapters.size(); i++) {
            Adapter current = adapters.get(i);
            Adapter previous = adapters.get(adapters.indexOf(current) - 1);
            if (current.joltageDelta(previous) == delta) {
                result++;
            }
        }

        return result + 1;
    }

    public long numberOfDistinctWaysToArrangeAdapters() {
        addAdditionalRequiredAdapters();

        return numberOfPossibleArrangementsForIndex(0);
    }

    private void addAdditionalRequiredAdapters() {
        Adapter chargingOutlet = new Adapter(0);
        adapters.add(0, chargingOutlet);
        Adapter lastAdapter = adapters.get(adapters.size() - 1);
        Adapter buildInJoltageAdapter = new Adapter(lastAdapter.getJoltage() + 3);
        adapters.add(buildInJoltageAdapter);
    }

    private long numberOfPossibleArrangementsForIndex(int index) {
        boolean isLastAdapter = index == adapters.size() - 1;
        if (isLastAdapter) {
            return 1;
        }

        if (memoizedNumberOfPossibleArrangements.containsKey(index)) {
            return memoizedNumberOfPossibleArrangements.get(index);
        }

        long result = 0;
        Adapter currentAdapter = adapters.get(index);
        // check next 3 Adapters
        for (int indexOfNextAdapter = index + 1; indexOfNextAdapter <= index + 3; indexOfNextAdapter++) {
            if (indexOfNextAdapter >= adapters.size()) break;

            Adapter nextAdapter = adapters.get(indexOfNextAdapter);
            if (nextAdapter.joltageDelta(currentAdapter) <= 3) {
                result += numberOfPossibleArrangementsForIndex(indexOfNextAdapter);
            }
        }

        memoizedNumberOfPossibleArrangements.put(index, result);
        return result;
    }

}
