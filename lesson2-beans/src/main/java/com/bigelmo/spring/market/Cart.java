package com.bigelmo.spring.market;

import java.util.List;

public interface Cart {

    boolean addProduct(Product product);

    Product getProductById(int id);

    List<Product> getAllProducts();

    @Override
    String toString();

    int getSize();
}
