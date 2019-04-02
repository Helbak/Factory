package code.service;


import code.domain.Product;

import java.util.List;

public interface ProductService {

        void addProduct(Product product);
        void supplyProduct(Long id, Float plusAmount, Float newPurchasePrice,Float newSellingPrice);
        void supplyProductFromInvoice(Product product, float sellingPrice, float purchasePrice, float plusAmount );
        List<Product> findProducts();
void newCostPrice(Product product, float plusAmount, float newPurchasePrice,float sellingPrice );
void newAmount(Product product,float plusAmount);
Product getProductById(Long id);
void saleProduct (long id, Float saleAmount);
float getsumProduct();
void supplyProductFromProduction(Product product);
}
