package code.service;

import code.domain.Ingredient;

import java.util.List;

public interface IngredientService {

    void addIngredient(Ingredient ingredient);

    void ingredientToProduce(Ingredient ingredient);
    List<Ingredient> findIngredientsDAO();
    Ingredient getIngredientById(Integer id);
    List<Ingredient> createListIngredients(Integer one, Integer two, Integer three, Integer four, Integer five);
    List<Ingredient> createListIngredients(Integer one, Integer two, Integer three, Integer four);
    List<Ingredient> createListIngredients(Integer one, Integer two, Integer three);
    List<Ingredient> createListIngredients(Integer one, Integer two);
    List<Ingredient> createListIngredients(Integer one);
    List<Ingredient> getIngredientsOfFormula(List<Integer> listIdIngredients);
}
