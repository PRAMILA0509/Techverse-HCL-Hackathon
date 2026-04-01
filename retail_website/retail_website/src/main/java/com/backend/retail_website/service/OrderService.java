package com.backend.retail_website.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.retail_website.model.Order;
import com.backend.retail_website.model.Cart;
import com.backend.retail_website.repository.OrderRepository;
import com.backend.retail_website.repository.CartRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private CartRepository cartRepo;

    public Order placeOrder(Long userId) {

        Cart cart = cartRepo.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        double total = cart.getItems().stream()
                .mapToDouble(item ->
                        item.getProduct().getPrice() * item.getQuantity())
                .sum();

        Order order = new Order();
        order.setUserId(userId);
        order.setTotalAmount(total);
        order.setStatus("PLACED");

        return orderRepo.save(order);
    }
}