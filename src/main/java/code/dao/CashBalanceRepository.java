package code.dao;

import code.domain.CashBalance;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CashBalanceRepository extends JpaRepository<CashBalance, Long> {
}
