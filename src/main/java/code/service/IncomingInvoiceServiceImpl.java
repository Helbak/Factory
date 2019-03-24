package code.service;

import code.dao.IncomingInvoiceRepository;
import code.domain.IncomingInvoice;
import code.domain.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class IncomingInvoiceServiceImpl implements IncomingInvoiceService{
    private IncomingInvoiceRepository incomingInvoiceRepository;
private ProductService productService;
private CashBalanceSevice cashBalanceSevice;

    @Override
    @Transactional
   public void addIncomingInvoice(IncomingInvoice incomingInvoice){

        incomingInvoiceRepository.save(incomingInvoice);
       productService.supplyProductFromInvoice(incomingInvoice.getProduct() , incomingInvoice.getSellingPrice(), incomingInvoice.getPurchasePrice(), incomingInvoice.getPlusAmount());
        float sumOfInvoice = - getSumOfInvoice(incomingInvoice);

       cashBalanceSevice.addCashBalance(new Date(), "payCash", incomingInvoice.getId(), sumOfInvoice);


    }
    @Override
    @Transactional
    public List<IncomingInvoice> findIncomingInvoice (){
        return incomingInvoiceRepository.findAll();
    }
    @Override
    @Transactional
    public float getSumOfInvoice (IncomingInvoice incomingInvoice){
        float sumOfInvoice = incomingInvoice.getPlusAmount()*incomingInvoice.getSellingPrice();
        return sumOfInvoice;
    }
    @Override
    @Transactional
    public float getsumBuying(){
        float sumBuying=0;
        List<IncomingInvoice> incomingInvoices = findIncomingInvoice();
        for(int i=0; i<incomingInvoices.size(); i++) {
            sumBuying =sumBuying+ incomingInvoices.get(i).getPlusAmount()*incomingInvoices.get(i).getPurchasePrice();
        }
        return sumBuying;
    }
}