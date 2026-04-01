package com.backend.retail_website.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backend.retail_website.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}