package com.backend.retail_website.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backend.retail_website.model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}