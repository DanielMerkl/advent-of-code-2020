package day04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PassportTest {

    @Test
    void containsAllRequiredProperties_true_1() {
        String input = """
                ecl:gry pid:860033327 eyr:2020 hcl:#fffffd
                byr:1937 iyr:2017 cid:147 hgt:183cm""";
        Passport passport = new Passport(input);

        boolean result = passport.containsAllRequiredProperties();

        assertTrue(result);
    }

    @Test
    void containsAllRequiredProperties_true_2() {
        String input = """
                hcl:#ae17e1 iyr:2013
                eyr:2024
                ecl:brn pid:760753108 byr:1931
                hgt:179cm""";
        Passport passport = new Passport(input);

        boolean result = passport.containsAllRequiredProperties();

        assertTrue(result);
    }

    @Test
    void containsAllRequiredProperties_false_1() {
        String input = """
                iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884
                hcl:#cfa07d byr:1929""";
        Passport passport = new Passport(input);

        boolean result = passport.containsAllRequiredProperties();

        assertFalse(result);
    }

    @Test
    void containsAllRequiredProperties_false_2() {
        String input = """
                hcl:#cfa07d eyr:2025 pid:166559648
                iyr:2011 ecl:brn hgt:59in""";
        Passport passport = new Passport(input);

        boolean result = passport.containsAllRequiredProperties();

        assertFalse(result);
    }

    @Test
    void allPropertiesAreValid_true_1() {
        String input = """
                eyr:1972 cid:100
                hcl:#18171d ecl:amb hgt:170 pid:186cm iyr:2018 byr:1926""";
        Passport passport = new Passport(input);

        boolean result = passport.allPropertiesAreValid();

        assertFalse(result);
    }

    @Test
    void allPropertiesAreValid_true_2() {
        String input = """
                iyr:2019
                hcl:#602927 eyr:1967 hgt:170cm
                ecl:grn pid:012533040 byr:1946""";
        Passport passport = new Passport(input);

        boolean result = passport.allPropertiesAreValid();

        assertFalse(result);
    }

    @Test
    void allPropertiesAreValid_true_3() {
        String input = """
                hcl:dab227 iyr:2012
                ecl:brn hgt:182cm pid:021572410 eyr:2020 byr:1992 cid:277""";
        Passport passport = new Passport(input);

        boolean result = passport.allPropertiesAreValid();

        assertFalse(result);
    }

    @Test
    void allPropertiesAreValid_true_4() {
        String input = """
                hgt:59cm ecl:zzz
                eyr:2038 hcl:74454a iyr:2023
                pid:3556412378 byr:2007""";
        Passport passport = new Passport(input);

        boolean result = passport.allPropertiesAreValid();

        assertFalse(result);
    }

    @Test
    void allPropertiesAreValid_false_1() {
        String input = """
                pid:087499704 hgt:74in ecl:grn iyr:2012 eyr:2030 byr:1980
                hcl:#623a2f""";
        Passport passport = new Passport(input);

        boolean result = passport.allPropertiesAreValid();

        assertTrue(result);
    }

    @Test
    void allPropertiesAreValid_false_2() {
        String input = """
                eyr:2029 ecl:blu cid:129 byr:1989
                iyr:2014 pid:896056539 hcl:#a97842 hgt:165cm""";
        Passport passport = new Passport(input);

        boolean result = passport.allPropertiesAreValid();

        assertTrue(result);
    }

    @Test
    void allPropertiesAreValid_false_3() {
        String input = """
                hcl:#888785
                hgt:164cm byr:2001 iyr:2015 cid:88
                pid:545766238 ecl:hzl
                eyr:2022""";
        Passport passport = new Passport(input);

        boolean result = passport.allPropertiesAreValid();

        assertTrue(result);
    }

    @Test
    void allPropertiesAreValid_false_4() {
        String input = """
                iyr:2010 hgt:158cm hcl:#b6652a ecl:blu byr:1944 eyr:2021 pid:093154719""";
        Passport passport = new Passport(input);

        boolean result = passport.allPropertiesAreValid();

        assertTrue(result);
    }
}
