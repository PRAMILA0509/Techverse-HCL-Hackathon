package com.backend.retail_website.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;
    private int stockQuantity;
    private boolean isAvailable;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}