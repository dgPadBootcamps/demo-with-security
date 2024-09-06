package com.dgpad.security.repository;

import com.dgpad.security.model.User;
import com.dgpad.security.model.UserCart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserCartRepository extends JpaRepository<UserCart, UUID> {
    UserCart findByUserId(String userId);
}
