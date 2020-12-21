package day21;

import java.util.Arrays;
import java.util.List;

public class Food {
    private final List<String> ingredients;
    private final List<String> allergens;

    public Food(String input) {
        String[] ingredientsAllergens = input.replace(")", "")
                .split(" \\(contains ");
        ingredients = Arrays.asList(ingredientsAllergens[0].split(" "));
        allergens = Arrays.asList(ingredientsAllergens[1].split(", "));
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public List<String> getAllergens() {
        return allergens;
    }
}
