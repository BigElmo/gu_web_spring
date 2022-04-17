package com.bigelmo.spring.market;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CartImpl implements Cart {

    private final List<Product> products;

    public CartImpl() {
        this.products = new ArrayList<>();
    }

    public boolean addProduct(Product product) {
        this.products.add(product);
        return true;
    }

    public Product getProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("В корзине:\n");
        for (Product product : products) {
            sb.append(product);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public int getSize() {
        return products.size();
    }
}
