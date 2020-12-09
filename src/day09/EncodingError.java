package day09;

import java.util.List;
import java.util.stream.Collectors;

public class EncodingError {
    private final List<Long> numbers;

    public EncodingError(String input) {
        numbers = input.lines()
                .map(Long::valueOf)
                .collect(Collectors.toList());
    }

    public long getFirstNumberThatIsNotSumOfTwoPreviousNumbers(int numberOfPreviousElements) {
        for (int i = numberOfPreviousElements; i < numbers.size(); i++) {
            List<Long> previousNumbers = numbers.subList(i - numberOfPreviousElements, i);
            Long currentNumber = numbers.get(i);
            if (!currentNumberEqualsSumOfTwoPreviousNumbers(currentNumber, previousNumbers)) {
                return currentNumber;
            }
        }

        throw new RuntimeException("Every number is valid.");
    }

    private boolean currentNumberEqualsSumOfTwoPreviousNumbers(Long requiredSum, List<Long> previousNumbers) {
        for (Long first : previousNumbers) {
            for (Long second : previousNumbers) {
                if (first + second == requiredSum) {
                    return true;
                }
            }
        }

        return false;
    }

    public long getEncryptionWeakness(long invalidNumber) {
        for (int numberOfCoherentElements = 2; numberOfCoherentElements <= numbers.size(); numberOfCoherentElements++) {
            for (int i = 0; i < numbers.size() - numberOfCoherentElements; i++) {
                List<Long> coherentElements = numbers.subList(i, i + numberOfCoherentElements);

                if (sum(coherentElements) == invalidNumber) {
                    return min(coherentElements) + max(coherentElements);
                }
            }
        }

        throw new RuntimeException("No encryption weakness was found.");
    }

    private long sum(List<Long> elements) {
        return elements.stream()
                .mapToLong(Long::longValue)
                .sum();
    }

    private long min(List<Long> elements) {
        return elements.stream()
                .mapToLong(Long::longValue)
                .min()
                .orElseThrow();
    }

    private long max(List<Long> elements) {
        return elements.stream()
                .mapToLong(Long::longValue)
                .max()
                .orElseThrow();
    }
}
