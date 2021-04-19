package com.ecommerce.shoes.service.impl;

import com.ecommerce.shoes.entity.Product;
import com.ecommerce.shoes.model.mapper.ProductMapper;
import com.ecommerce.shoes.model.request.CreateProductReq;
import com.ecommerce.shoes.repository.ProductRepository;
import com.ecommerce.shoes.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getListProductSale() {
        return productRepository.getListProductSale();
    }

    @Override
    public void createProduct(CreateProductReq req) {
        Product product = ProductMapper.toProduct(req);
        productRepository.save(product);
    }
}
