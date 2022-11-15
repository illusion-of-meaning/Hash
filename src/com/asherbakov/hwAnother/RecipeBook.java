package com.asherbakov.hwAnother;

import com.asherbakov.hwAnother.exceptions.ExistingRecipeException;

import java.util.HashSet;
import java.util.Set;

public class RecipeBook {
    private final Set<Recipe> recipeSet = new HashSet<>();

    public void addRecipe(Recipe recipe) {
        if (!recipeSet.contains(recipe)) {
            recipeSet.add(recipe);
        } else {
            throw new ExistingRecipeException("Рецепт уже есть в книге.");
        }
    }

    @Override
    public String toString() {
        String result = "";
        for (Recipe r : recipeSet) {
            result += r.toString();
        }
        return result;
    }
}
