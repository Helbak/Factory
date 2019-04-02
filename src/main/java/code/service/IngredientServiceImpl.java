package code.service;

import code.dao.IngredientRepository;
import code.domain.Ingredient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class IngredientServiceImpl implements IngredientService{
private IngredientRepository ingredientRepository;
    @Override
    @Transactional
    public void addIngredient(Ingredient ingredient){
        ingredientRepository.save(ingredient);
    }
    @Override
    @Transactional
    public void ingredientToProduce(Ingredient ingredient){}
    @Override
    @Transactional
    public List<Ingredient> findIngredientsDAO(){
        return ingredientRepository.findAll();
    }
    @Override
    @Transactional
    public Ingredient getIngredientById(Integer id){
        List<Ingredient> ingredients = findIngredientsDAO();

        for (Ingredient ingredient:ingredients){
            if (id==ingredient.getId())
                return ingredient;
        }
        return null;
    }
    @Override
    @Transactional
   public boolean checkResourcesForFormula(Ingredient ingredient, int amount){
//      if(ingredient.getRaw().getAmount()<=ingredient.getWeight()*amount){
//         return false;}
        return true;

    }
    @Override
    @Transactional
    public float getIngredientsCostPrice(Ingredient ingredient){

       return ingredient.getWeight()*ingredient.getRaw().getCostPrice()/1000;
    }

}
