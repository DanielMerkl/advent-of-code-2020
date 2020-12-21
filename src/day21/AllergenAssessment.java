package day21;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AllergenAssessment {
    private final List<Food> foods;
    private final Map<String, String> ingredientForAllergen = new HashMap<>();

    public AllergenAssessment(String input) {
        foods = input.lines()
                .map(Food::new)
                .collect(Collectors.toList());

        Set<String> possibleAllergens = foods.stream()
                .map(Food::getAllergens)
                .flatMap(List::stream)
                .collect(Collectors.toSet());

        Map<String, Set<String>> allergenWithCorrespondingIngredients = new HashMap<>();

        for (String allergen : possibleAllergens) {
            List<Food> foodsWithAllergen = foods.stream()
                    .filter(food -> food.containsAllergene(allergen))
                    .collect(Collectors.toList());

            Predicate<String> ingredientIsInsideAllFoodsWithAllergens = ingredient -> foodsWithAllergen.stream()
                    .allMatch(foodWithAllergen -> foodWithAllergen.containsIngredient(ingredient));

            Set<String> remainingIngredients = foodsWithAllergen.stream()
                    .map(Food::getIngredients)
                    .flatMap(List::stream)
                    .filter(ingredientIsInsideAllFoodsWithAllergens)
                    .collect(Collectors.toSet());

            allergenWithCorrespondingIngredients.put(allergen, remainingIngredients);
        }

        boolean allergensAppearInMultipleCorrespongingIngredients = true;

        while (allergensAppearInMultipleCorrespongingIngredients) {
            Set<String> ingredientsThatAppearInOnlyOncePerAllergen = allergenWithCorrespondingIngredients.values()
                    .stream()
                    .filter(ingredients -> ingredients.size() == 1)
                    .flatMap(Set::stream)
                    .collect(Collectors.toSet());

            for (Set<String> correspondingIngredients : allergenWithCorrespondingIngredients.values()) {
                if (correspondingIngredients.size() > 1) {
                    correspondingIngredients.removeAll(ingredientsThatAppearInOnlyOncePerAllergen);
                }
            }

            allergensAppearInMultipleCorrespongingIngredients = allergenWithCorrespondingIngredients.values()
                    .stream()
                    .anyMatch(ingredients -> ingredients.size() > 1);
        }


        allergenWithCorrespondingIngredients.forEach((allergen, ingredients) -> {
            String correspondingIngredient = ingredients.stream()
                    .findAny()
                    .orElseThrow();
            ingredientForAllergen.put(allergen, correspondingIngredient);
        });
    }

    public long partOne() {
        Set<String> ingredientsWithAllergens = new HashSet<>(ingredientForAllergen.values());

        return foods.stream()
                .map(Food::getIngredients)
                .flatMap(List::stream)
                .filter(Predicate.not(ingredientsWithAllergens::contains))
                .count();
    }

    public String partTwo() {
        return ingredientForAllergen.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.joining(","));
    }
}
