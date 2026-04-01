package com.backend.retail_website.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backend.retail_website.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}