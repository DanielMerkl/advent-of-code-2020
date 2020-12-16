package day16;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ticket {
    private final List<Long> values;

    public Ticket(String input) {
        values = Arrays.stream(input.split(","))
                .map(Long::parseLong)
                .collect(Collectors.toList());
    }

    public List<Long> getValues() {
        return values;
    }
}
