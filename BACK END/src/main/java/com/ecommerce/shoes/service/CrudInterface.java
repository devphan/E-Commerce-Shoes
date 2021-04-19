package com.ecommerce.shoes.service;

import java.util.List;

public interface CrudInterface<T, K> {

    List<T> findAll();

    T findById(K id);

    T insert (T entity);

    void update(K id, T entity);

    void delete(K id);
}
