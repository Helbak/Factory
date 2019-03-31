package code.service;

import code.domain.Formula;

import java.util.List;

public interface FormulaService {
    void addFormula(Formula formula);
    List<Formula> findFormula();
    Formula getFormulaById(long id);
    float getWeightOfFormula (long id);
   float getCostPriceFormula (long id);
}
