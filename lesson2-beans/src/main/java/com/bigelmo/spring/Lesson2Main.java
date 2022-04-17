package com.bigelmo.spring;

import com.bigelmo.spring.market.CartService;
import com.bigelmo.spring.market.ProductRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

public class Lesson2Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        ProductRepository repository = ctx.getBean("productRepository", ProductRepository.class);
        repository.addProduct("Пылесос", BigDecimal.valueOf(20000));
        repository.addProduct("Телевизор", BigDecimal.valueOf(50000));
        repository.addProduct("Микроволновая печь", BigDecimal.valueOf(15000));
        repository.addProduct("Утюг", BigDecimal.valueOf(5000));
        repository.addProduct("Чайник", BigDecimal.valueOf(2000));
        repository.showAll();

        CartService cartService = ctx.getBean("cartService", CartService.class);
        cartService.showAll();

        cartService.addToCart(repository.getProductById(3));
        cartService.addToCart(repository.getProductById(2));
        cartService.showAll();

        cartService.showTotalCost();

        cartService = ctx.getBean("cartService", CartService.class);
        cartService.showAll();
    }
}
