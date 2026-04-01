package com.backend.retail_website.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backend.retail_website.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}