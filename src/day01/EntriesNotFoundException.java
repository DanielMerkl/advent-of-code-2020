package day01;

public class EntriesNotFoundException extends RuntimeException {
    public EntriesNotFoundException(int requiredSum) {
        super("Could not find entries for sum: " + requiredSum);
    }
}
