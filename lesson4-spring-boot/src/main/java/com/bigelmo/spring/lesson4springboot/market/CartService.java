package com.bigelmo.spring.lesson4springboot.market;

import java.util.List;

public interface CartService {

    boolean addToCart(Long id);

    void removeFromCart(Long id);

    List<Product> getAllProducts();
}
