package com.bigelmo.spring.lesson4springboot.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class ProductDto {

    private Long id;

    @NotBlank(message = "Укажите название")
    private String name;

    @Min(value = 0, message = "Не может быть меньше 0")
    @Max(value = 100000, message = "Не может быть больше 100 000")
    private int cost;

    public ProductDto(Long id, String name, int cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public ProductDto() {
    }
}
