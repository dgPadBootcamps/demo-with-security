package com.dgpad.security.service;

import com.dgpad.security.model.Product;
import com.dgpad.security.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public Product createProduct(String name, Integer price){
        return productRepository.save(new Product(name,price));
    }

    public Product findProduct(String id){
        Optional<Product> productOptional = productRepository.findById(UUID.fromString(id));
        if(productOptional.isPresent())
            return productOptional.get();
        return null;
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }
}
