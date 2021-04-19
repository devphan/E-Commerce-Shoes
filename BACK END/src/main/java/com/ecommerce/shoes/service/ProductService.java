package com.ecommerce.shoes.service;

import com.ecommerce.shoes.entity.Product;
import com.ecommerce.shoes.model.request.CreateProductReq;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<Product> getListProductSale();

    void createProduct(CreateProductReq req);

}
