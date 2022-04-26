package com.bigelmo.spring.lesson4springboot.market;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Scope("prototype")
public class CartServiceImpl implements CartService {

    private final List<Long> cart = new ArrayList<>();
    private final ProductRepository repository;

    @Autowired
    public CartServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean addToCart(Long id) {
        cart.add(id);
        return true;
    }

    @Override
    public void removeFromCart(Long id) {
        cart.remove(id);
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        for (Long id : cart) {
            if (repository.getProductById(id) != null) {
                products.add(repository.getProductById(id));
            }
        }
        return products;
    }
}
