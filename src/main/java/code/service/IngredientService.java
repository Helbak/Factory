package code.service;

import code.domain.Ingredient;

import java.util.List;

public interface IngredientService {

    void addIngredient(Ingredient ingredient);

    void ingredientToProduce(Ingredient ingredient);
    List<Ingredient> findIngredientsDAO();
    Ingredient getIngredientById(Integer id);
    boolean checkResourcesForFormula(Ingredient ingredient, int amount);
    float getIngredientsCostPrice(Ingredient ingredient);

}
