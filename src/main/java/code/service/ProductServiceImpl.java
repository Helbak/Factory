package code.service;

import code.dao.ProductRepository;
import code.domain.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{
private ProductRepository productRepository;


    @Override
    @Transactional
    public void addProduct(Product product){

        productRepository.save(product);
    }

    @Override
    @Transactional
    public void supplyProductFromInvoice(Product product, float sellingPrice, float purchasePrice, float plusAmount ){
        product.setSellingPrice(sellingPrice);
        newAmount(product, plusAmount);
        newCostPrice(product, plusAmount,purchasePrice, sellingPrice);
    }
    @Override
    @Transactional
    public Product getProductById(Long id){
        List<Product> products = findProducts();

            for (Product product:products){
                if (id==product.getId())
                    return product;
            }
       return null;
    }

    @Override
    @Transactional
    public void supplyProduct(Long id, Float plusAmount, Float newPurchasePrice,Float newSellingPrice){
        Product product = getProductById(id);
         product.setSellingPrice(newSellingPrice);
        newAmount(product, plusAmount);
newCostPrice(product, plusAmount,newPurchasePrice,newSellingPrice);
    }
    @Override
    @Transactional
    public void newAmount (Product product,float plusAmount){
      float oldAmount = product.getAmount();
      product.setAmount(oldAmount+plusAmount);
    }
    @Override
    @Transactional
    public void newCostPrice(Product product, float plusAmount, float newPurchasePrice,float sellingPrice ){
        float oldAmount = product.getAmount();
        float oldCostPrice = product.getCostPrice();
        product.setCostPrice((oldCostPrice*oldAmount+newPurchasePrice*plusAmount)/(oldAmount+plusAmount));
    }

    @Override
    @Transactional
    public List<Product> findProducts() {
        return productRepository.findAll();
    }
    @Override
    @Transactional
   public void saleProduct (long id, Float saleAmount){
        Product product = getProductById(id);
        float oldAmount = product.getAmount();
        product.setAmount(oldAmount-saleAmount);
    }

}
