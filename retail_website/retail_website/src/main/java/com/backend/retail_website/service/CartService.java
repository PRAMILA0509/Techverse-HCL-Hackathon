package com.backend.retail_website.service;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.retail_website.model.Cart;
import com.backend.retail_website.model.CartItem;
import com.backend.retail_website.model.Product;
import com.backend.retail_website.repository.CartRepository;
import com.backend.retail_website.repository.ProductRepository;
import com.backend.retail_website.repository.CartItemRepository;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepo;

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private CartItemRepository cartItemRepo;

    // Get or create cart
    public Cart getCart(Long userId) {
        return cartRepo.findByUserId(userId)
                .orElseGet(() -> {
                    Cart cart = new Cart();
                    cart.setUserId(userId);
                    return cartRepo.save(cart);
                });
    }

    // Add to cart
    public Cart addToCart(Long userId, Long productId, int quantity) {

        Cart cart = getCart(userId);

        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        CartItem item = new CartItem();
        item.setCart(cart);
        item.setProduct(product);
        item.setQuantity(quantity);

        cart.getItems().add(item);

        return cartRepo.save(cart);
    }

    // Remove item
    public void removeItem(Long itemId) {
        cartItemRepo.deleteById(itemId);
    }

    // Clear cart
    @Transactional
    public void clearCart(Long userId) {
        Cart cart = getCart(userId);
        cart.getItems().clear();   // now this WILL delete from DB
    }
}