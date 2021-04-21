package com.ecommerce.shoes.service.impl;

import com.ecommerce.shoes.entity.Brand;
import com.ecommerce.shoes.entity.Category;
import com.ecommerce.shoes.entity.Product;
import com.ecommerce.shoes.exception.NotFoundException;
import com.ecommerce.shoes.model.dto.ProductDto;
import com.ecommerce.shoes.model.mapper.ProductMapper;
import com.ecommerce.shoes.model.request.ProductReq;
import com.ecommerce.shoes.repository.ProductRepository;
import com.ecommerce.shoes.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getListProductSale() {
        return productRepository.getListProductSale();
    }

    @Override
    public void saveProduct(ProductReq req) {
        Product product = ProductMapper.toProduct(req);
        productRepository.save(product);
    }

    @Override
    public List<ProductDto> findAllProductInfo() {
        List<Product> products = productRepository.findAll();
        List<ProductDto> result = new ArrayList<ProductDto>();
        for (Product product: products) {
            result.add(ProductMapper.toProductDto(product));
        }
        return result;
    }

    @Override
    public Page<Product> findAllByNameContaining(String name, Pageable pageable) {
        return productRepository.findAllByNameContaining(name, pageable);
    }

    @Override
    public List<Product> getListProductBestSeller() {
        return productRepository.getListProductBestSeller();
    }

    @Override
    public Page<Product> findAllPage(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id).get();
    }

    @Override
    public void updateProduct(int id, ProductReq req) {
        Optional<Product> productFind = productRepository.findById(id);
        if (productFind.isEmpty()) {
            throw new NotFoundException("Product does not exists");
        }
        Product product = productFind.get();

        product.setName(req.getName());
        product.setPrice(req.getPrice());
        product.setDescription(req.getDescription());
        product.setImage(req.getImage());

        //Set Brand
        Brand brand = new Brand();
        brand.setId(req.getBrandId());
        product.setBrand(brand);
        // Set category
        ArrayList<Category> categories = new ArrayList<Category>();
        for (Integer i : req.getCategoryIds()) {
            Category category = new Category();
            category.setId(i);
            categories.add(category);
        }
        product.setCategories(categories);
        productRepository.save(product);
    }

    @Override
    public void removeProduct(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findAllByBrand(int id) {
        return productRepository.findAllByBrand(id);
    }
}
