package com.bigelmo.spring.lesson4springboot.service;

import com.bigelmo.spring.lesson4springboot.dto.ProductDto;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface ProductService {

    Page<ProductDto> findProductsByFilter(String nameFilter, Integer page, Integer size);

    Optional<ProductDto> findById(Long id);

    ProductDto save (ProductDto product);

    void deleteById(Long id);
}
