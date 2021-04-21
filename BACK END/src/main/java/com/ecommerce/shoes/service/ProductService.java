package com.ecommerce.shoes.service;

import com.ecommerce.shoes.entity.Product;
import com.ecommerce.shoes.model.dto.ProductDto;
import com.ecommerce.shoes.model.request.ProductReq;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<ProductDto> findAllProductInfo();

    Page<Product> findAllPage(Pageable pageable);

    List<Product> findAllByBrand(int id);

    List<Product> getListProductSale();

    List<Product> getListProductBestSeller();

    Page<Product> findAllByNameContaining(String name, Pageable pageable);

    Product findById(int id);

    void saveProduct(ProductReq req);

    void updateProduct(int id, ProductReq req);

    void removeProduct(int id);



}
