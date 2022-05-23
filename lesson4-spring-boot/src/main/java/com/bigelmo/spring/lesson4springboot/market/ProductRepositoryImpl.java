package com.bigelmo.spring.lesson4springboot.market;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final Map<Long, Product> repository = new ConcurrentHashMap<>();
    private final AtomicLong identity = new AtomicLong(0);

    @PostConstruct
    public void init() {
//        this.save(new Product("Пылесос1", 20000));
//        this.save(new Product("Телевизор1", 50000));
//        this.save(new Product("Микроволновая печь1", 15000));
//        this.save(new Product("Утюг1", 5000));
//        this.save(new Product("Чайник1", 2000));
//        this.save(new Product("Пылесос2", 21000));
//        this.save(new Product("Телевизор2", 51000));
//        this.save(new Product("Микроволновая печь2", 16000));
//        this.save(new Product("Утюг2", 6000));
//        this.save(new Product("Чайник2", 3000));
    }

    @Override
    public Product save(Product product) {
        if (product.getId() == null) {
            product.setId(identity.incrementAndGet());
        }
        repository.put(product.getId(), product);
        return product;
    }

    @Override
    public void deleteProduct(Long id) {
        repository.remove(id);
    }

    @Override
    public Product getProductById(Long id) {
        return repository.get(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(repository.values());
    }
}
