package com.ecommerce.shoes.service.impl;

import com.ecommerce.shoes.entity.Category;
import com.ecommerce.shoes.repository.CategoryRepository;
import com.ecommerce.shoes.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Integer id) {
        return null;
    }

    @Override
    public Category insert(Category entity) {
        return null;
    }

    @Override
    public void update(Integer id, Category entity) {

    }

    @Override
    public void delete(Integer id) {

    }
}
