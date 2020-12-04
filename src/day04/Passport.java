package day04;

import java.util.HashMap;

public class Passport {
    private final HashMap<String, String> properties = new HashMap<>();

    public Passport(String input) {
        String trimmedInput = input.trim();
        String[] lines = trimmedInput.split("\n");
        for (String line : lines) {
            String[] properties = line.split(" ");
            for (String property : properties) {
                String[] keyValue = property.split(":");
                this.properties.put(keyValue[0], keyValue[1]);
            }
        }
    }

    public boolean containsAllRequiredProperties() {
        return properties.containsKey("byr") &&
                properties.containsKey("iyr") &&
                properties.containsKey("eyr") &&
                properties.containsKey("hgt") &&
                properties.containsKey("hcl") &&
                properties.containsKey("ecl") &&
                properties.containsKey("pid");
    }

    public boolean allPropertiesAreValid() {
        return isValidBirthYear() &&
                isValidIssueYear() &&
                isValidExpirationYear() &&
                isValidHeight() &&
                isValidHairColor() &&
                isValidEyeColor() &&
                isValidPassportId();
    }

    private boolean isValidBirthYear() {
        int birthYear = Integer.parseInt(properties.get("byr"));
        return birthYear >= 1920 && birthYear <= 2002;
    }

    private boolean isValidIssueYear() {
        int issueYear = Integer.parseInt(properties.get("iyr"));
        return issueYear >= 2010 && issueYear <= 2020;
    }

    private boolean isValidExpirationYear() {
        int expirationYear = Integer.parseInt(properties.get("eyr"));
        return expirationYear >= 2020 && expirationYear <= 2030;
    }

    private boolean isValidHeight() {
        String height = properties.get("hgt");
        if (height.contains("cm")) {
            int cm = Integer.parseInt(height.replaceAll("cm", ""));
            return cm >= 150 && cm <= 193;
        } else {
            int in = Integer.parseInt(height.replaceAll("in", ""));
            return in >= 59 && in <= 76;
        }
    }

    private boolean isValidHairColor() {
        String hairColor = properties.get("hcl");
        return hairColor.charAt(0) == '#' && hairColor.length() == 7;
    }

    private boolean isValidEyeColor() {
        String eyeColor = properties.get("ecl");
        return eyeColor.equals("amb") ||
                eyeColor.equals("blu") ||
                eyeColor.equals("brn") ||
                eyeColor.equals("gry") ||
                eyeColor.equals("grn") ||
                eyeColor.equals("hzl") ||
                eyeColor.equals("oth");
    }

    private boolean isValidPassportId() {
        String passportId = properties.get("pid");
        return passportId.length() == 9;
    }
}
