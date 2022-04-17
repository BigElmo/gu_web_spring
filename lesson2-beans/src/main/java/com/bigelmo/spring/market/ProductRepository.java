package com.bigelmo.spring.market;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository {
    boolean addProduct(String name, BigDecimal cost);

    Product getProductById(int id);

    List<Product> getAllProducts();

    @Override
    String toString();

    void showAll();
}
