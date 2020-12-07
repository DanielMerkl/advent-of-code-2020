package day07;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandyHaversacksTest {
    @Test
    void numberOfBagsThatCanContainAtLeastOneShinyGoldBag_test() {
        HandyHaversacks handyHaversacks = new HandyHaversacks(testInput);

        int result = handyHaversacks.numberOfBagsThatCanContainAtLeastOneShinyGoldBag();

        assertEquals(4, result);
    }

    @Test
    void numberOfBagsThatCanContainAtLeastOneShinyGoldBag() {
        HandyHaversacks handyHaversacks = new HandyHaversacks(Input.input);

        int result = handyHaversacks.numberOfBagsThatCanContainAtLeastOneShinyGoldBag();

        assertEquals(192, result);
    }

    @Test
    void numberOfBagsInsideOfShinyGoldBag_test() {
        HandyHaversacks handyHaversacks = new HandyHaversacks(testInput);

        int result = handyHaversacks.numberOfBagsInsideOfShinyGoldBag();

        assertEquals(32, result);
    }

    @Test
    void numberOfBagsInsideOfShinyGoldBag() {
        HandyHaversacks handyHaversacks = new HandyHaversacks(Input.input);

        int result = handyHaversacks.numberOfBagsInsideOfShinyGoldBag();

        assertEquals(12128, result);
    }

    private final String testInput = """
            light red bags contain 1 bright white bag, 2 muted yellow bags.
            dark orange bags contain 3 bright white bags, 4 muted yellow bags.
            bright white bags contain 1 shiny gold bag.
            muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.
            shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.
            dark olive bags contain 3 faded blue bags, 4 dotted black bags.
            vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.
            faded blue bags contain no other bags.
            dotted black bags contain no other bags.""";
}
