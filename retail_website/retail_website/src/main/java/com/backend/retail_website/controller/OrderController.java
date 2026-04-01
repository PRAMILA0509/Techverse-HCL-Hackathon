package com.backend.retail_website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.backend.retail_website.model.Order;
import com.backend.retail_website.service.OrderService;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping("/place")
    public Order placeOrder(@RequestParam Long userId) {
        return service.placeOrder(userId);
    }
}