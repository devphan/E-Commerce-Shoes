package com.ecommerce.shoes.service;

import com.ecommerce.shoes.entity.Brand;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BrandService extends CrudInterface<Brand> {

    @Override
    List<Brand> findAll();

    @Override
    Brand insert(Brand entity);

    @Override
    Brand findById(int id);

    @Override
    void update(int i, Brand entity);

    @Override
    void delete(int id);
}
