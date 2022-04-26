package com.bigelmo.spring.lesson4springboot.controller;

import com.bigelmo.spring.lesson4springboot.market.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/cart")
@Controller
public class CartController {

    private final CartService cart;

    @Autowired
    public CartController(CartService cart) {
        this.cart = cart;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("products", cart.getAllProducts());
        return "cart";
    }

    @GetMapping("/add/{id}")
    public String add(@PathVariable("id") Long id) {
        cart.addToCart(id);
        return "redirect:/product/list";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Long id) {
        cart.removeFromCart(id);
        return "redirect:/cart";
    }
}
