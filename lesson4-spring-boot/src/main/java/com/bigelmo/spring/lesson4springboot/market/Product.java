package com.bigelmo.spring.lesson4springboot.market;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private int cost;

    public Product(Long id, String name, int cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public Product() {
    }
}
