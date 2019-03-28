package code.service;

import code.dao.RawInvoiceRepository;
import code.domain.RawInvoice;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class RawInvoiceServiceImpl implements RawInvoiceService{

    private RawInvoiceRepository rawInvoiceRepository;
    private CashBalanceService cashBalanceService;
    private RawService rawService;

   public void addRawInvoice(RawInvoice rawInvoice){
       float sumOfInvoice = - getSumOfInvoice(rawInvoice);
       cashBalanceService.addCashBalance(new Date(), "payRaw", rawInvoice.getId(), sumOfInvoice);
       rawService.supplyRaw(rawInvoice.getRaw(),rawInvoice.getPlusAmount(), rawInvoice.getPurchasePrice());
rawInvoiceRepository.save(rawInvoice);
   }
   public List<RawInvoice> findRawInvoice (){
       return rawInvoiceRepository.findAll();
   }
    public float getSumOfInvoice (RawInvoice rawInvoice){
      float sumOfInvoice = rawInvoice.getPlusAmount()*rawInvoice.getPurchasePrice();
        return sumOfInvoice;
    }
   public float getsumRaws(){
       float sumRaws=0;
       List<RawInvoice> rawInvoices = findRawInvoice();
       for(int i=0; i<rawInvoices.size(); i++) {
           sumRaws =sumRaws+ rawInvoices.get(i).getPlusAmount()*rawInvoices.get(i).getPurchasePrice();
       }
       return sumRaws;
   }



}
