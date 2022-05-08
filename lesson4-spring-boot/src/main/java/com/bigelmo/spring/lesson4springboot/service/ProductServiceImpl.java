package com.bigelmo.spring.lesson4springboot.service;

import com.bigelmo.spring.lesson4springboot.controller.ProductSpecifications;
import com.bigelmo.spring.lesson4springboot.dto.ProductDto;
import com.bigelmo.spring.lesson4springboot.market.Product;
import com.bigelmo.spring.lesson4springboot.market.ProductJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductJpaRepository productJpaRepository;

    @Autowired
    public ProductServiceImpl(ProductJpaRepository productJpaRepository) {
        this.productJpaRepository = productJpaRepository;
    }

    @Override
    public Page<ProductDto> findProductsByFilter(String nameFilter, Integer page, Integer size) {
        Specification<Product> spec = Specification.where(null);
        if (nameFilter != null) {
            spec = spec.and(ProductSpecifications.nameContaining(nameFilter));
        }

        return productJpaRepository.findAll(spec, PageRequest.of(page, size))
                .map(ProductServiceImpl::productToDto);
    }

    @Override
    public Optional<ProductDto> findById(Long id) {
        return productJpaRepository.findById(id).map(ProductServiceImpl::productToDto);
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        Product product = new Product(productDto.getId(), productDto.getName(), productDto.getCost());
        return productToDto(productJpaRepository.save(product));
    }

    @Override
    public void deleteById(Long id) {
        productJpaRepository.deleteById(id);
    }

    private static ProductDto productToDto(Product product) {
        return new ProductDto(product.getId(), product.getName(), product.getCost());
    }
}
