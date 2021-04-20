package com.ecommerce.shoes.service;

import java.util.List;

public interface CrudInterface<T> {

    List<T> findAll();

    T findById(int id);

    T insert (T entity);

    void update(int id, T entity);

    void delete(int id);
}
