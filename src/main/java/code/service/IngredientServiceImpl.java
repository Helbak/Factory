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
    public List<Ingredient> createListIngredients(Integer one, Integer two, Integer three, Integer four, Integer five){
        List<Integer> listIngredients = new ArrayList<Integer>();
        listIngredients.add(one);
        listIngredients.add(two);
        listIngredients.add(three);
        listIngredients.add(four);
        listIngredients.add(five);

        return getIngredientsOfFormula(listIngredients);
    }
    @Override
    @Transactional
    public List<Ingredient> createListIngredients(Integer one, Integer two, Integer three, Integer four){
        List<Integer> listIngredients = new ArrayList<Integer>();
        listIngredients.add(one);
        listIngredients.add(two);
        listIngredients.add(three);
        listIngredients.add(four);

        return getIngredientsOfFormula(listIngredients);
    }
    @Override
    @Transactional
    public List<Ingredient> createListIngredients(Integer one, Integer two, Integer three){
        List<Integer> listIngredients = new ArrayList<Integer>();
        listIngredients.add(one);
        listIngredients.add(two);
        listIngredients.add(three);

        return getIngredientsOfFormula(listIngredients);
    }
    @Override
    @Transactional
    public List<Ingredient> createListIngredients(Integer one, Integer two){
        List<Integer> listIngredients = new ArrayList<Integer>();
        listIngredients.add(one);
        listIngredients.add(two);

        return getIngredientsOfFormula(listIngredients);
    }
    @Override
    @Transactional
    public List<Ingredient> createListIngredients(Integer one){
        List<Integer> listIngredients = new ArrayList<Integer>();
        listIngredients.add(one);

        return getIngredientsOfFormula(listIngredients);
    }
    @Override
    @Transactional
    public List<Ingredient> getIngredientsOfFormula(List<Integer> listIdIngredients){
        List<Ingredient> ingredientsOfFormula=new ArrayList<Ingredient>();
        for(int i=0; i<listIdIngredients.size(); i++){
            ingredientsOfFormula.add(getIngredientById(listIdIngredients.get(i)));
        }
        return ingredientsOfFormula;
    }
}
