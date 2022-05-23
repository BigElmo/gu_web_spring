package com.bigelmo.spring.lesson4springboot.controller;

import com.bigelmo.spring.lesson4springboot.dto.ProductDto;
import com.bigelmo.spring.lesson4springboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RequestMapping("/product")
@Controller
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String main() {
        return "redirect:/product/list";
    }

    @GetMapping("/list")
    public String list(
            @RequestParam Optional<String> nameFilter,
            @RequestParam Optional<Integer> page,
            @RequestParam Optional<Integer> size,
            Model model
    ) {
        String nameFilterVal = nameFilter.filter(s -> !s.isBlank()).orElse(null);
        Integer pageVal = page.orElse(1) - 1;
        Integer sizeVal = size.orElse(5);

        model.addAttribute(
                "products",
                productService.findProductsByFilter(nameFilterVal, pageVal, sizeVal)
        );
        return "product_list";
    }

    @GetMapping("/{id}")
    public String card(@PathVariable("id") Long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "product_card";
    }

    @GetMapping("/new")
    public String card(Model model) {
        model.addAttribute("product", new ProductDto());
        return "product_card";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("product") ProductDto productDto, BindingResult binding) {
        if (binding.hasErrors()) {
            return "product_card";
        }
        productService.save(productDto);
        return "redirect:/product/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        productService.deleteById(id);
        return "redirect:/product/list";
    }
}
