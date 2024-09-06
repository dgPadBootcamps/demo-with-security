package com.dgpad.security.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "cat")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCart {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;

    private String userId;

    @ManyToMany(cascade = {CascadeType.ALL, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    private List<Product> products;

    public UserCart(String userId) {
        this.userId = userId;
        this.products = new ArrayList<>();
    }
}
