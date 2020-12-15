package day14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DockingData {
    List<Instruction> instructions = new ArrayList<>();
    Map<Long, Long> memory = new HashMap<>();

    public DockingData(String input) {
        String[] lines = input.split("\n");

        int index = -1;
        for (String line : lines) {
            if (line.startsWith("mask")) {
                index++;
                Instruction instruction = new Instruction(line.substring(7));
                instructions.add(instruction);
            } else if (line.startsWith("mem")) {
                Instruction instruction = instructions.get(index);
                WriteOperation writeOperation = new WriteOperation(line);
                instruction.addWriteOperation(writeOperation);
            }
        }
    }

    public long partOne() {
        for (Instruction instruction : instructions) {
            String mask = instruction.getMask();

            for (WriteOperation writeOperation : instruction.getWriteOperations()) {
                long memoryAddress = writeOperation.getMemoryAddress();
                long value = writeOperation.getValue();

                String binaryString = toBinaryWithLeadingZeros(value);
                StringBuilder resultString = new StringBuilder();

                for (int i = 0; i < mask.length(); i++) {
                    char maskCharacter = mask.charAt(i);
                    switch (maskCharacter) {
                        case '0' -> resultString.append('0');
                        case '1' -> resultString.append('1');
                        case 'X' -> resultString.append(binaryString.charAt(i));
                        default -> throw new RuntimeException("Illegal mask character: " + maskCharacter);
                    }
                }

                Long result = Long.valueOf(resultString.toString(), 2);
                memory.put(memoryAddress, result);
            }
        }

        return getSumOfAllValuesLeftInMemory();
    }

    public long partTwo() {
        for (Instruction instruction : instructions) {
            String mask = instruction.getMask();

            for (WriteOperation writeOperation : instruction.getWriteOperations()) {
                long value = writeOperation.getValue();
                long memoryAddress = writeOperation.getMemoryAddress();

                List<Long> writeAddresses = getWriteAddresses(memoryAddress, mask);

                for (Long writeAddress : writeAddresses) {
                    memory.put(writeAddress, value);
                }
            }
        }

        return getSumOfAllValuesLeftInMemory();
    }

    private List<Long> getWriteAddresses(long memoryAddress, String mask) {
        StringBuilder result = new StringBuilder();
        String binaryString = toBinaryWithLeadingZeros(memoryAddress);

        char[] charArray = mask.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            switch (c) {
                case '0' -> result.append(binaryString.charAt(i));
                case '1' -> result.append('1');
                case 'X' -> result.append('X');
            }
        }

        return getAllPossibleAddresses(result.toString()).collect(Collectors.toList());
    }

    private Stream<Long> getAllPossibleAddresses(String input) {
        if (!input.contains("X")) {
            return Stream.of(Long.parseLong(input, 2));
        }

        Stream<Long> addressesWithZero = getAllPossibleAddresses(input.replaceFirst("X", "0"));
        Stream<Long> addressesWithOne = getAllPossibleAddresses(input.replaceFirst("X", "1"));
        return Stream.concat(addressesWithZero, addressesWithOne);
    }

    private String toBinaryWithLeadingZeros(long memoryAddress) {
        return String.format("%36s", Long.toBinaryString(memoryAddress))
                .replace(' ', '0');
    }

    private long getSumOfAllValuesLeftInMemory() {
        return memory.values()
                .stream()
                .mapToLong(Long::longValue)
                .sum();
    }
}
