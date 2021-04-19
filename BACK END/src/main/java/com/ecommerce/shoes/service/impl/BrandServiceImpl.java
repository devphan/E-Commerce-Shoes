package com.ecommerce.shoes.service.impl;

import com.ecommerce.shoes.entity.Brand;
import com.ecommerce.shoes.exception.NotFoundException;
import com.ecommerce.shoes.repository.BrandRepository;
import com.ecommerce.shoes.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandRepository brandRepository;

    @Override
    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    @Override
    public Brand findById(Integer id) {
        return brandRepository.findById(id).get();
    }

    @Override
    public Brand insert(Brand entity) {
        return brandRepository.save(entity);
    }

    @Override
    public void update(Integer id, Brand entity) {
        Optional<Brand> result = brandRepository.findById(id);
        if (result.isEmpty()) {
            throw new NotFoundException("Brand does not exist");
        }
        Brand brand = result.get();
        brand.setId(id);
        brand.setName(entity.getName());
        brand.setThumbnail(entity.getThumbnail());

        brandRepository.save(brand);
    }

    @Override
    public void delete(Integer id) {
        brandRepository.deleteById(id);
    }
}
