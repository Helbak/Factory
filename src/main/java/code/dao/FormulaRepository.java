package code.dao;

import code.domain.Formula;
import code.domain.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormulaRepository extends JpaRepository<Formula, Long> {
}
