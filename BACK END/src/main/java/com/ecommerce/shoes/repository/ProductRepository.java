package com.ecommerce.shoes.repository;

import com.ecommerce.shoes.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "SELECT * FROM product p WHERE p.discount > 0", nativeQuery = true)
    List<Product> getListProductSale();
}
