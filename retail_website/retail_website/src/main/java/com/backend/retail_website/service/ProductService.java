package com.backend.retail_website.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.backend.retail_website.model.Product;
import com.backend.retail_website.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public List<Product> getAll() {
        return repo.findAll();
    }

    public Product add(Product product) {
        return repo.save(product);
    }
}