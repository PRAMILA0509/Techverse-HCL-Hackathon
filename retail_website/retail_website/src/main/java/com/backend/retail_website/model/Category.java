package com.backend.retail_website.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
