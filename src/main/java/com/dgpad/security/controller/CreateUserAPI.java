package com.dgpad.security.controller;

import com.dgpad.security.config.UserInfoDetails;
import com.dgpad.security.model.Product;
import com.dgpad.security.model.User;
import com.dgpad.security.model.UserCart;
import com.dgpad.security.service.ProductService;
import com.dgpad.security.service.UserCartService;
import com.dgpad.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.plaf.PanelUI;
import java.util.List;

@RestController
public class CreateUserAPI {
    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserCartService userCartService;

    @GetMapping(value = "/create-user")
    public String createUser(@RequestParam String username, @RequestParam String password){
        userService.createUser(username,password);
        return "user created!!";
    }

    @GetMapping(value = "/create-admin")
    public String createAdmin(@RequestParam String username, @RequestParam String password){
        userService.createAdmin(username,password);
        return "Admin created!!";
    }

    @GetMapping(value = "/create-product")
    public String createProduct(@RequestParam String name, @RequestParam Integer price){
        productService.createProduct(name,price);
        return "product is created!!";
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/products")
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @GetMapping(value = "/add-to-cart")
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    public UserCart addToCart(@RequestParam String pid) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserInfoDetails userInfoDetails = (UserInfoDetails) authentication.getPrincipal();
        UserCart userCart = userCartService.addToCart(userInfoDetails.getUsername(),pid);
        return userCart;
    }

}
