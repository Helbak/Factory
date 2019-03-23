package code.service;

import code.dao.SalesInvoiceRepository;
import code.domain.SalesInvoice;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class SalesInvoiceServiceImpl implements SalesInvoiceService{
    private SalesInvoiceRepository salesInvoiceRepository;
    private ProductService productService;
    @Override
    @Transactional
    public void addSalesInvoice(SalesInvoice salesInvoice){

        salesInvoiceRepository.save(salesInvoice);
        productService.saleProduct(salesInvoice.getProduct().getId(), salesInvoice.getSalesAmount());
    }
    @Override
    @Transactional
    public List<SalesInvoice> findSalesInvoice (){
        return salesInvoiceRepository.findAll();
    }

}
