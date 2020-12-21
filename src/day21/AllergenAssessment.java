package day21;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AllergenAssessment {
    private final List<Food> foods;
    private final List<String> possibleIngredients;
    private final List<String> possibleAllergens;
    private final Map<String, List<String>> allergensMap = new HashMap<>();

    public AllergenAssessment(String input) {
        foods = input.lines()
                .map(Food::new)
                .collect(Collectors.toList());
        possibleIngredients = foods.stream()
                .map(Food::getIngredients)
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());
        possibleAllergens = foods.stream()
                .map(Food::getAllergens)
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());

        initializeAllergensMap();
        removeUnambiguousIngredients();
    }

    private void initializeAllergensMap() {
        for (String possibleAllergen : possibleAllergens) {
            List<Food> foodWithAllergen = foods.stream()
                    .filter(food -> food.getAllergens()
                            .contains(possibleAllergen))
                    .collect(Collectors.toList());

            List<String> remainingIngredients = foodWithAllergen.get(0)
                    .getIngredients();

            for (Food food : foodWithAllergen) {
                remainingIngredients = remainingIngredients.stream()
                        .distinct()
                        .filter(ingredient -> food.getIngredients()
                                .contains(ingredient))
                        .collect(Collectors.toList());
            }

            allergensMap.put(possibleAllergen, remainingIngredients);
        }
    }

    private void removeUnambiguousIngredients() {
        while (allergensMapHasMultipleIngredients()) {
            List<String> unambiguousIngredients = allergensMap.values()
                    .stream()
                    .filter(ingredients -> ingredients.size() == 1)
                    .flatMap(List::stream)
                    .collect(Collectors.toList());

            for (String unambiguousIngredient : unambiguousIngredients) {
                allergensMap.forEach((_allergen, ingredients) -> {
                    if (ingredients.size() > 1) {
                        ingredients.remove(unambiguousIngredient);
                    }
                });
            }
        }
    }

    private boolean allergensMapHasMultipleIngredients() {
        return allergensMap.values()
                .stream()
                .anyMatch(ingredients -> ingredients.size() > 1);
    }

    public long partOne() {
        List<String> ingredientsWithAllergens = allergensMap.values()
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        List<String> ingredientsWithoutAllergens = possibleIngredients.stream()
                .filter(Predicate.not(ingredientsWithAllergens::contains))
                .collect(Collectors.toList());

        long count = 0;

        for (Food food : foods) {
            for (String ingredientWithoutAllergens : ingredientsWithoutAllergens) {
                List<String> ingredients = food.getIngredients();
                if (ingredients.contains(ingredientWithoutAllergens)) {
                    count++;
                }
            }
        }

        return count;
    }

    public String partTwo() {
        return possibleAllergens.stream()
                .sorted()
                .map(allergen -> allergensMap.get(allergen).get(0))
                .collect(Collectors.joining(","));
    }
}
