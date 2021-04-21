package com.ecommerce.shoes.repository;

import com.ecommerce.shoes.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "SELECT * FROM product p WHERE p.discount > 0 LIMIT 5", nativeQuery = true)
    List<Product> getListProductSale();

    @Query(value = "SELECT * FROM product p ORDER BY p.total_sold DESC  LIMIT 5", nativeQuery = true)
    List<Product> getListProductBestSeller();

    @Query(value = "SELECT * FROM product p WHERE p.brand_id = :idBrand", nativeQuery = true)
    List<Product> findAllByBrand(@Param("idBrand") int id);

    Page<Product> findAllByNameContaining(String name, Pageable pageable);

}

