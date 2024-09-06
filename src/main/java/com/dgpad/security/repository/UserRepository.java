package com.dgpad.security.repository;

import com.dgpad.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    @Query(value = "select * from users where username= ?1", nativeQuery = true)
    Optional<User> findUserByName(String name);
}
