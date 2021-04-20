package com.ecommerce.shoes.service;

import com.ecommerce.shoes.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService extends CrudInterface<Category> {

    @Override
    List<Category> findAll();

    @Override
    Category findById(int id);

    @Override
    Category insert(Category entity);

    @Override
    void update(int id,Category entity);

    @Override
    void delete(int id);
}
