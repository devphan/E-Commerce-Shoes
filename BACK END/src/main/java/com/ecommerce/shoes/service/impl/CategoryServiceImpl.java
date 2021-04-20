package com.ecommerce.shoes.service.impl;

import com.ecommerce.shoes.entity.Category;
import com.ecommerce.shoes.exception.NotFoundException;
import com.ecommerce.shoes.repository.CategoryRepository;
import com.ecommerce.shoes.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(int id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public Category insert(Category entity) {
        return categoryRepository.save(entity);
    }

    @Override
    public void update(int id, Category entity) {
        Optional<Category> categoryFind = categoryRepository.findById(id);
        if (categoryFind.isEmpty()) {
            throw new NotFoundException("Category does not exist");
        }
        Category category = categoryFind.get();
        category.setId(id);
        category.setName(entity.getName());

        categoryRepository.save(category);
    }

    @Override
    public void delete(int id) {
        categoryRepository.deleteById(id);
    }
}
