package code.service;

import code.dao.CashBalanceRepository;
import code.domain.CashBalance;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class CashBalanceServiceImpl implements CashBalanceSevice{
    private CashBalanceRepository cashBalanceRepository;
    @Override
    @Transactional
    public void addCashBalance (Date data, String payReceive, long idInvoice, float sumOfInvoice){
         float oldCashBalance =  getLastBalance ();
        float newCashBalance = oldCashBalance+sumOfInvoice;
        CashBalance cashBalance = new CashBalance(data, payReceive, idInvoice, newCashBalance);
        cashBalanceRepository.save(cashBalance);
    }
    @Override
    @Transactional
    public List<CashBalance> findCashBalance (){
        return cashBalanceRepository.findAll();
    }
    @Override
    @Transactional
    public float getLastBalance (){
      int idLastCashBalance =  findCashBalance().size()-1;
        float lastCashBalance = findCashBalance().get(idLastCashBalance).getCashBalance();
        return lastCashBalance;
    }
    @Override
    @Transactional
    public  void manualAddCashBalance(CashBalance cashBalance){
        cashBalanceRepository.save(cashBalance);
    }

}
