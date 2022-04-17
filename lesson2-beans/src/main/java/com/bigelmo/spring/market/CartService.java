package com.bigelmo.spring.market;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CartService {

    private final Cart cart;

    public CartService(Cart cart) {
        this.cart = cart;
    }

    public void showAll() {
        if (cart.getSize() == 0) {
            System.out.println("В корзине пусто\n");
        } else {
            System.out.println(this.cart);
        }
    }

    public void addToCart(Product product) {
        cart.addProduct(product);
    }

    public void showTotalCost() {
        BigDecimal cost = BigDecimal.valueOf(0);
        for (Product product : cart.getAllProducts()) {
            cost = cost.add(product.getCost());
        }
        System.out.println("Итого: " + cost + "\n");
    }
}
