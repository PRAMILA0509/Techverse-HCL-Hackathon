package com.backend.retail_website.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backend.retail_website.model.Cart;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByUserId(Long userId);
}