package code.service;


import code.domain.Product;

import java.util.List;

public interface ProductService {

        void addProduct(Product product);
        List<Product> findProducts();

}
