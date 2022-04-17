package com.bigelmo.spring.market;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final List<Product> products;

    public ProductRepositoryImpl() {
        this.products = new ArrayList<>();
    }

    public boolean addProduct(String name, BigDecimal cost) {
        this.products.add(new Product(products.size() + 1, name, cost));
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
        StringBuilder sb = new StringBuilder("В магазине:\n");
        for (Product product : products) {
            sb.append(product);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public void showAll() {
        if (products.size() == 0) {
            System.out.println("В магазине пусто\n");
        } else {
            System.out.println(this);
        }
    }
}
