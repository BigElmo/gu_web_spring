package com.bigelmo.spring.lesson4springboot.controller;

import com.bigelmo.spring.lesson4springboot.market.Product;
import org.springframework.data.jpa.domain.Specification;

public final class ProductSpecifications {

    public static Specification<Product> nameContaining(String name) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), "%" + name + "%"));
    }
}
