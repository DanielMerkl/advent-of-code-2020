package day14;

public class WriteOperation {
    private final long memoryAddress;
    private final long value;

    public WriteOperation(String input) {
        String[] split = input.substring(4)
                .split("] = ");
        memoryAddress = Long.parseLong(split[0]);
        value = Long.parseLong(split[1]);
    }

    public long getMemoryAddress() {
        return memoryAddress;
    }

    public long getValue() {
        return value;
    }
}
