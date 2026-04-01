package com.backend.retail_website.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backend.retail_website.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
