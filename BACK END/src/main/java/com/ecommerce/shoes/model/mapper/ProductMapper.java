package com.ecommerce.shoes.model.mapper;

import com.ecommerce.shoes.entity.Brand;
import com.ecommerce.shoes.entity.Category;
import com.ecommerce.shoes.entity.Product;
import com.ecommerce.shoes.model.request.CreateProductReq;

import java.util.ArrayList;

public class ProductMapper {
    public static Product toProduct(CreateProductReq req) {
        //Convert data request --> entity
        Product product = new Product();
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
        for (Integer id : req.getCategoryIds()) {
            Category category = new Category();
            category.setId(id);
            categories.add(category);
        }
        product.setCategories(categories);
        return product;
    }
}
