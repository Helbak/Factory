package code.service;

import code.dao.FormulaRepository;
import code.domain.Formula;
import code.domain.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import java.util.List;
@Service
@AllArgsConstructor
public class FormulaServiceImpl implements FormulaService {
private FormulaRepository formulaRepository;
private IngredientService ingredientService;
    @Override
    @Transactional
    public void addFormula(Formula formula){
formulaRepository.save(formula);
    }
    @Override
    @Transactional
   public List<Formula> findFormula(){
        return formulaRepository.findAll();
    }
    @Override
    @Transactional
   public Formula getFormulaById(long id){
        List<Formula> formulas = findFormula();

        for (Formula formula:formulas){
            if (id==formula.getId())
                return formula;
        }
        return null;
    }
    @Override
    @Transactional
    public float getWeightOfFormula (long id){
      return 0;
    }
    @Override
    @Transactional
    public float getCostPriceFormula (Formula formula){
        float costPrice=0;
        if(formula.getOne()==null){costPrice=0;}
        if(formula.getOne()!=null) {
           costPrice=costPrice+ingredientService.getIngredientsCostPrice(formula.getOne());}
        if(formula.getTwo()!=null) {
         costPrice=costPrice+ingredientService.getIngredientsCostPrice(formula.getTwo());
        }
        if(formula.getThree()!=null) {
            costPrice=costPrice+ingredientService.getIngredientsCostPrice(formula.getThree());
        }
        if(formula.getFour()!=null) {
            costPrice=costPrice+ingredientService.getIngredientsCostPrice(formula.getFour());
        }
        if(formula.getFive()!=null) {
            costPrice=costPrice+ingredientService.getIngredientsCostPrice(formula.getFive());
        }
        return costPrice;
    }
    @Override
    @Transactional
    public boolean checkResourcesForFormula(Formula formula, int amount){

        if(formula.getOne()==null){return false;}
        if(formula.getOne()!=null & ingredientService.checkResourcesForFormula(formula.getOne(), amount)==false){return false;}
        if(formula.getTwo()!=null & ingredientService.checkResourcesForFormula(formula.getTwo(), amount)==false){return false;}
        if(formula.getTwo()!=null & ingredientService.checkResourcesForFormula(formula.getThree(), amount)==false){return false;}
        if(formula.getTwo()!=null & ingredientService.checkResourcesForFormula(formula.getFour(), amount)==false){return false;}
        if(formula.getTwo()!=null & ingredientService.checkResourcesForFormula(formula.getFive(), amount)==false){return false;}

       return true;
    }
    @Override
    @Transactional
    public int getAmountOfIngredients(Formula formula){
        int amount = 0;
        if(formula.getOne()==null){amount = 0;}
        if(formula.getTwo()==null){amount=1;}
        if(formula.getThree()==null){amount=2;}
        if(formula.getFour()==null){amount=3;}
        if(formula.getFive()==null){amount=4;}
        if(formula.getFive()!=null){amount=5;}
        return amount;
    }
    @Override
    @Transactional
    public Product createObjectProduct(Formula formula, int amountInt, float markup){
         String name = formula.getName();
         String producer = "Own Production";
         String measure = "item";
         float amount = (float)amountInt;
        float costPrice = getCostPriceFormula(formula);
        float purchasePrice = costPrice;
         float sellingPrice = costPrice*markup/100+costPrice;
         Product product = new Product(name, producer,measure,amount, purchasePrice,sellingPrice,costPrice);
         return product;
    }
}
