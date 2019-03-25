package code.service;

import code.dao.ProfitRepository;
import code.domain.Profit;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ProfitServiceImpl implements ProfitService{
    private ProfitRepository profitRepository;
    @Override
    @Transactional
    public void addProfit (Date data, String payReceive, long idInvoice, float oneProfit){
        float oldProfit = getLastTotalProfit();
        float totalProfit = oldProfit + oneProfit;
        Profit profit = new Profit(data, payReceive, idInvoice, oneProfit, totalProfit);
        profitRepository.save(profit);
    }

    @Override
    @Transactional
    public float getLastTotalProfit (){
        if( findProfit().size()>0){
            return findProfit().get(findProfit().size()-1).getTotalProfit();
        }
        return 0;
          }
    @Override
    @Transactional
    public List<Profit> findProfit (){
      return  profitRepository.findAll();
    }

}
