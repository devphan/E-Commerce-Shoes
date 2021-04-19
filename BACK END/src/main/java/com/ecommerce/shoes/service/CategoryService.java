package com.ecommerce.shoes.service;

import com.ecommerce.shoes.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService extends CrudInterface<Category, Integer> {

    @Override
    List<Category> findAll();


    @Override
    Category insert(Category entity);

    @Override
    void update(Integer id,Category entity);

    @Override
    void delete(Integer id);
}
