package com.bigelmo.spring.lesson4springboot.market;

import java.util.List;

public interface ProductRepository {

    Product save(Product product);

    void deleteProduct(Long id);

    Product getProductById(Long id);

    List<Product> getAllProducts();
}
