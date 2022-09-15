package com.innovation.innovation_clone_be.Product.Repository;

import com.innovation.innovation_clone_be.Product.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findProductById(Long id);
    List<Product> findAllByOrderByCartNumDesc();
}