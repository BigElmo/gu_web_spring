package com.bigelmo.spring;

import com.bigelmo.spring.market.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("com.bigelmo.spring")
public class AppConfig {

    @Bean
    public ProductRepository productRepository() {
        return new ProductRepositoryImpl();
    }

    @Bean
    @Scope("prototype")
    public Cart cart() {
        return new CartImpl();
    }

    @Bean
    @Scope("prototype")
    public CartService cartService(Cart cart) {
        return new CartService(cart);
    }
}
