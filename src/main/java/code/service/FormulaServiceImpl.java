package code.service;

import code.dao.FormulaRepository;
import code.domain.Formula;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import java.util.List;
@Service
@AllArgsConstructor
public class FormulaServiceImpl implements FormulaService {
private FormulaRepository formulaRepository;
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
    public float getCostPriceFormula (long id){
        return 0;
    }



}
