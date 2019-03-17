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
    public Product getProductById(Long id){
        Product product = productRepository.getOne(id);
       return product;
    }

    @Override
    @Transactional
    public void supplyProduct(Product product, float plusAmount, float newPurchasePrice,float newSellingPrice){
        product.setSellingPrice(newSellingPrice);
        newAmount(product, plusAmount);

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
        product.setCostPrice((oldCostPrice/oldAmount+newPurchasePrice/plusAmount)/(oldAmount+plusAmount));
    }

    @Override
    @Transactional
    public List<Product> findProducts() {
        return productRepository.findAll();
    }



}
