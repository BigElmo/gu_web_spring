package com.bigelmo.spring.dao;

import java.util.List;

public interface Dao<T> {

    T findById(Long id);

    List<T> findAll();

    void deleteById(Long id);

    T saveOrUpdate(T item);
}
