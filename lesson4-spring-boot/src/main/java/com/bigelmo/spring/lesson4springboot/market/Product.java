package com.bigelmo.spring.lesson4springboot.market;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Укажите название")
    @Column(nullable = false)
    private String name;

    @Min(value = 0, message = "Не может быть меньше 0")
    @Max(value = 100000, message = "Не может быть больше 100 000")
    @Column(nullable = false)
    private int cost;

    public Product(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public Product() {
    }
}
