package day07;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HandyHaversacks {
    private final Map<Bag, Map<Bag, Integer>> bags = new HashMap<>();

    public HandyHaversacks(String input) {
        String[] lines = input.split("\n");
        for (String line : lines) {
            String[] split = line.split(" bags contain ");
            Bag bag = new Bag(split[0]);
            String[] containedBagsWithAmount = split[1].split(", ");

            Map<Bag, Integer> containedBags = new HashMap<>();
            for (String containedBagWithAmount : containedBagsWithAmount) {
                if (containedBagWithAmount.equals("no other bags.")) {
                    continue;
                }
                Integer amount = Integer.valueOf(containedBagWithAmount.substring(0, 1));
                String color = containedBagWithAmount.substring(2)
                        .replace(" bags", "")
                        .replace(" bag", "")
                        .replace(".", "");
                containedBags.put(new Bag(color), amount);
            }

            bags.put(bag, containedBags);
        }
    }

    public int numberOfBagsThatCanContainAtLeastOneShinyGoldBag() {
        Bag shinyGoldBag = new Bag("shiny gold");
        Set<Bag> bagsContainingShinyGoldBagRecursively = new HashSet<>();

        for (int i = 0; i < bags.size(); i++) {
            bags.forEach((bag, containedBags) -> {
                containedBags.forEach((containedBag, _amount) -> {
                    if (containedBag.equals(shinyGoldBag)
                            || bagsContainingShinyGoldBagRecursively.contains(containedBag)) {
                        bagsContainingShinyGoldBagRecursively.add(bag);
                    }
                });
            });
        }

        return bagsContainingShinyGoldBagRecursively.size();
    }

    public int numberOfBagsInsideOfShinyGoldBag() {
        Bag shinyGoldBag = new Bag("shiny gold");

        return calcNumberOfBagsInsideOfBag(shinyGoldBag) - 1;
    }

    private int calcNumberOfBagsInsideOfBag(Bag bag) {
        int result = 1;
        Map<Bag, Integer> containedBags = bags.get(bag);

        for (Map.Entry<Bag, Integer> entry : containedBags.entrySet()) {
            Bag containedBag = entry.getKey();
            Integer amount = entry.getValue();
            result += amount * calcNumberOfBagsInsideOfBag(containedBag);
        }

        return result;
    }
}
