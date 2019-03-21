package code.service;

import code.dao.IncomingInvoiceRepository;
import code.domain.IncomingInvoice;
import code.domain.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class IncomingInvoiceServiceImpl implements IncomingInvoiceService{
    private IncomingInvoiceRepository incomingInvoiceRepository;
private ProductService productService;
    @Override
    @Transactional
   public void addIncomingInvoice(IncomingInvoice incomingInvoice){

        incomingInvoiceRepository.save(incomingInvoice);
       productService.supplyProductFromInvoice(incomingInvoice.getProduct() , incomingInvoice.getSellingPrice(), incomingInvoice.getPurchasePrice(), incomingInvoice.getPlusAmount());
    }
    @Override
    @Transactional
    public List<IncomingInvoice> findIncomingInvoice (){
        return incomingInvoiceRepository.findAll();
    }
}
