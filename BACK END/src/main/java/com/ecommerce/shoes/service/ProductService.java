package com.ecommerce.shoes.service;

import com.ecommerce.shoes.entity.Product;
import com.ecommerce.shoes.model.dto.ProductDto;
import com.ecommerce.shoes.model.request.ProductReq;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<ProductDto> findAllProductInfo();

    List<Product> getListProductSale();

    Product findById(int id);

    void saveProduct(ProductReq req);

    void updateProduct(int id, ProductReq req);


}
