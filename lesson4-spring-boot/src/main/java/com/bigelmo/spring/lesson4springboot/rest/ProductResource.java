package com.bigelmo.spring.lesson4springboot.rest;

import com.bigelmo.spring.lesson4springboot.dto.ProductDto;
import com.bigelmo.spring.lesson4springboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/rest/product")
@RestController
public class ProductResource {

    private final ProductService productService;

    @Autowired
    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    private Page<ProductDto> findAll(@RequestParam Optional<String> nameFilter,
                                     @RequestParam Optional<Integer> page,
                                     @RequestParam Optional<Integer> size) {
        String nameFilterVal = nameFilter
                .filter(s -> !s.isBlank())
                .orElse(null);
        Integer pageVal = page.orElse(1) - 1;
        Integer sizeVal = size.orElse(5);
        return productService.findProductsByFilter(
                nameFilterVal,
                pageVal,
                sizeVal);
    }

    @GetMapping("/{id}/id")
    public ProductDto findById(@PathVariable Long id) {
        return productService.findById(id).orElse(null);
    }

    @PostMapping
    public ProductDto create(@RequestBody ProductDto productDto) {
        if (productDto.getId() != null) {
            return null;
        }
        return productService.save(productDto);
    }

    @PutMapping
    public ProductDto update(@RequestBody ProductDto productDto) {
        if (productDto.getId() == null) {
            return null;
        }
        return productService.save(productDto);
    }

    @DeleteMapping("/{id}/id")
    public void delete(@PathVariable Long id) {
        if (productService.findById(id).isPresent()) {
            productService.deleteById(id);
        }
    }
}
