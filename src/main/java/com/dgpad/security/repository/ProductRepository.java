package com.dgpad.security.repository;

import com.dgpad.security.model.Product;
import com.dgpad.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
