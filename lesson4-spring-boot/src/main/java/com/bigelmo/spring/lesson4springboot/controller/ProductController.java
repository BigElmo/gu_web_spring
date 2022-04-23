package com.bigelmo.spring.lesson4springboot.controller;

import com.bigelmo.spring.lesson4springboot.market.Product;
import com.bigelmo.spring.lesson4springboot.market.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping("/product")
@Controller
public class ProductController {

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public String main() {
        return "redirect:/product/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("products", productRepository.getAllProducts());
        return "product_list";
    }

    @GetMapping("/{id}")
    public String card(@PathVariable("id") Long id, Model model) {
        model.addAttribute("product", productRepository.getProductById(id));
        return "product_card";
    }

    @GetMapping("/new")
    public String card(Model model) {
        model.addAttribute("product", new Product("", 0));
        return "product_card";
    }

    @PostMapping("/save")
    public String save(@Valid Product product, BindingResult binding) {
        if (binding.hasErrors()) {
            return "product_card";
        }
        productRepository.save(product);
        return "redirect:/product/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        productRepository.deleteProduct(id);
        return "redirect:/product/list";
    }
}
