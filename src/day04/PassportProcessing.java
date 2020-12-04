package day04;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PassportProcessing {
    private final List<Passport> passports;

    public PassportProcessing(String input) {
        String[] split = input.split("\n\n");
        passports = Arrays.stream(split)
                .map(Passport::new)
                .collect(Collectors.toList());
    }

    public int getNumberOfValidPassports() {
        return (int) passports.stream()
                .filter(Passport::containsAllRequiredProperties)
                .count();
    }

    public int getNumberOfValidPassportsPartTwo() {
        return (int) passports.stream()
                .filter(Passport::containsAllRequiredProperties)
                .filter(Passport::allPropertiesAreValid)
                .count();
    }
}
