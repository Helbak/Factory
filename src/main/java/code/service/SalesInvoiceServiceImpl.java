package code.service;

import code.dao.SalesInvoiceRepository;
import code.domain.SalesInvoice;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class SalesInvoiceServiceImpl implements SalesInvoiceService{
    private SalesInvoiceRepository salesInvoiceRepository;
    private ProductService productService;
    private CashBalanceSevice cashBalanceSevice;
    @Override
    @Transactional
    public void addSalesInvoice(SalesInvoice salesInvoice){

        float sumOfInvoice = getSumOfInvoice(salesInvoice);

        cashBalanceSevice.addCashBalance(new Date(), "receiveCash", salesInvoice.getId(), sumOfInvoice);




        salesInvoiceRepository.save(salesInvoice);
        productService.saleProduct(salesInvoice.getProduct().getId(), salesInvoice.getSalesAmount());
    }
    @Override
    @Transactional
    public List<SalesInvoice> findSalesInvoice (){
        return salesInvoiceRepository.findAll();
    }

    @Override
    @Transactional
    public float getSumOfInvoice (SalesInvoice salesInvoice){
        float sumOfInvoice = salesInvoice.getSalesAmount() *salesInvoice.getProduct().getSellingPrice();
        return sumOfInvoice;
    }
}
