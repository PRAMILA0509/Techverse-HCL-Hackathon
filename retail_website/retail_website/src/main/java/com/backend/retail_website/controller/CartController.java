package com.backend.retail_website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.backend.retail_website.model.Cart;
import com.backend.retail_website.service.CartService;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin
public class CartController {

    @Autowired
    private CartService service;

    @GetMapping("/{userId}")
    public Cart getCart(@PathVariable Long userId) {
        return service.getCart(userId);
    }

    @PostMapping("/add")
    public Cart addToCart(@RequestParam Long userId,
                          @RequestParam Long productId,
                          @RequestParam int quantity) {
        return service.addToCart(userId, productId, quantity);
    }

    @DeleteMapping("/remove/{itemId}")
    public String removeItem(@PathVariable Long itemId) {
        service.removeItem(itemId);
        return "Item removed successfully";
    }

    @DeleteMapping("/clear/{userId}")
    public String clearCart(@PathVariable Long userId) {
        service.clearCart(userId);
        return "Cart cleared";
    }
}