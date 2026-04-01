package com.backend.retail_website.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.retail_website.model.User;
import com.backend.retail_website.repository.UserRepository;

@Service
public class AuthService {

    @Autowired
    private UserRepository repo;

    public User register(User user) {
        return repo.save(user);
    }

    public User login(String email, String password) {
        User user = repo.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        throw new RuntimeException("Invalid credentials");
    }
}