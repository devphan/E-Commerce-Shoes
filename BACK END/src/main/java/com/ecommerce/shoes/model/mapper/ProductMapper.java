package com.ecommerce.shoes.model.mapper;

import com.ecommerce.shoes.entity.Brand;
import com.ecommerce.shoes.entity.Category;
import com.ecommerce.shoes.entity.Product;
import com.ecommerce.shoes.model.dto.ProductDto;
import com.ecommerce.shoes.model.request.ProductReq;

import java.util.ArrayList;

public class ProductMapper {

    public static ProductDto toProductDto(Product product) {
        //Convert Entity sang DTO
        ProductDto dto = new ProductDto();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setImage(product.getImage());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setTotalSold(product.getTotalSold());
        dto.setBrand(product.getBrand().getName());
        ArrayList<String> categoriesName = new ArrayList<String>();
        for (Category category : product.getCategories()) {
            categoriesName.add(category.getName());
        }
        dto.setCategories(categoriesName);
        return dto;
    }


    public static Product toProduct(ProductReq req) {
        //Convert data request --> entity
        Product product = new Product();
        product.setName(req.getName());
        product.setPrice(req.getPrice());
        product.setDescription(req.getDescription());
        product.setImage(req.getImage());

        Brand brand = new Brand();
        brand.setId(req.getBrandId());
        product.setBrand(brand);

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
