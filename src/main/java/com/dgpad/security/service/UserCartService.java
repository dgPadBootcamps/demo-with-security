package com.dgpad.security.service;

import com.dgpad.security.model.Product;
import com.dgpad.security.model.User;
import com.dgpad.security.model.UserCart;
import com.dgpad.security.repository.UserCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserCartService {
    @Autowired
    private UserCartRepository userCartRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;
    public UserCart addToCart(String username,String productId) throws Exception {
        Optional<User> optionalUser = userService.findUserByUserName(username);
       if(optionalUser.isPresent()){
           User user = optionalUser.get();
           UserCart userCart = userCartRepository.findByUserId(user.getId().toString());
           if(userCart == null){
               UserCart newUserCart = new UserCart(user.getId().toString());
               Product product = productService.findProduct(productId);
               if(product!=null)
                   newUserCart.getProducts().add(product);
               return userCartRepository.save(newUserCart);
           }else{
               Product product = productService.findProduct(productId);
               userCart.getProducts().add(product);
               return userCartRepository.save(userCart);
           }
       }

       return null;

    }
}
