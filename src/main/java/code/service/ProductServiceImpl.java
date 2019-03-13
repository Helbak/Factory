package code.service;

import code.dao.ProductRepository;
import code.domain.Product;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ProductServiceImpl implements ProductService{
private ProductRepository productRepository;

    @Override
    @Transactional
    public void addProduct(Product product){
        productRepository.save(product);
    }
    @Override
    @Transactional
    public List<Product> findProducts() {
        return productRepository.findAll();
    }

}
