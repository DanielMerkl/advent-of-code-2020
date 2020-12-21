package day21;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FoodTest {

    @Test
    void initializesCorrectly() {
        Food food = new Food("mxmxvkd kfcds sqjhc nhms (contains dairy, fish)");

        List<String> ingredients = food.getIngredients();
        List<String> allergens = food.getAllergens();

        assertTrue(ingredients.contains("mxmxvkd"));
        assertTrue(ingredients.contains("kfcds"));
        assertTrue(ingredients.contains("sqjhc"));
        assertTrue(ingredients.contains("nhms"));

        assertTrue(allergens.contains("dairy"));
        assertTrue(allergens.contains("fish"));
    }

}
