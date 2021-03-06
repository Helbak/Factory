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
    private CashBalanceService cashBalanceService;
    private ProfitService profitService;
    @Override
    @Transactional
    public void addSalesInvoice(SalesInvoice salesInvoice){

        float sumOfInvoice = getSumOfInvoice(salesInvoice);
        Date data = new Date();
        cashBalanceService.addCashBalance(data, "receiveCash", salesInvoice.getId(), sumOfInvoice);
        float oneProfit = salesInvoice.getSalesAmount()*(salesInvoice.getProduct().getSellingPrice()-salesInvoice.getProduct().getCostPrice());
        profitService.addProfit(data,"receiveCash",salesInvoice.getId(), oneProfit);
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
    @Override
    @Transactional
    public float getsumSales(){
        List<SalesInvoice> salesInvoices = findSalesInvoice();
        float sumSales=0;
        for(int i=0; i<salesInvoices.size(); i++) {
            sumSales =sumSales+ salesInvoices.get(i).getSalesAmount()  * salesInvoices.get(i).getProduct().getSellingPrice();
        }
        return sumSales;
    }

}
