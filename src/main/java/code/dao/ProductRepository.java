package code.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import code.domain.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {
}
