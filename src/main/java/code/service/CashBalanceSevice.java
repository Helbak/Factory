package code.service;

import code.domain.CashBalance;

import java.util.Date;
import java.util.List;

public interface CashBalanceSevice {
    void addCashBalance(Date data, String payReceive, long idInvoice, float sumOfInvoice);
    void manualAddCashBalance(CashBalance cashBalance);
    float getLastBalance ();
    List<CashBalance> findCashBalance ();

}
