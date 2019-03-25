package code.service;

import code.domain.Profit;

import java.util.Date;
import java.util.List;

public interface ProfitService {
    void addProfit(Date data, String payReceive, long idInvoice, float oneProfit);
//    void manualAddCashBalance(CashBalance cashBalance);
    float getLastTotalProfit ();
    List<Profit> findProfit ();
}
