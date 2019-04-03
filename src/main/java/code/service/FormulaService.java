package code.service;

import code.domain.Formula;
import code.domain.Ingredient;
import code.domain.Product;

import java.util.List;

public interface FormulaService {
    void addFormula(Formula formula);
    List<Formula> findFormula();
    int getAmountOfIngredients(Formula formula);
    Formula getFormulaById(long id);
    Product createObjectProduct(Formula formula, int amount, float markup);
    float getWeightOfFormula (long id);
   float getCostPriceFormula (Formula formula);
   boolean checkResourcesForFormula(Formula formula, int amount);
   Formula preConstructorTwo (String name, String measure, Ingredient one, Ingredient two);
}
