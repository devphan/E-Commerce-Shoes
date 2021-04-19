package com.ecommerce.shoes.service;

import com.ecommerce.shoes.entity.Brand;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BrandService extends CrudInterface<Brand, Integer> {

    @Override
    List<Brand> findAll();

    @Override
    Brand insert(Brand entity);

    @Override
    Brand findById(Integer id);

    @Override
    void update(Integer i, Brand entity);

    @Override
    void delete(Integer id);
}
