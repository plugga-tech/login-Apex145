package com.login.Login.Service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.login.Login.Model.Product.Products;
import com.login.Login.Model.User.User;
import com.login.Login.Repository.ProductsRepository;
import com.login.Login.Repository.UserRepository;

@Service
public class ApplicationService {

    private final ProductsRepository productsRepository;

    private final UserRepository userRepository;

    private final PasswordEncoder bCryptEncoder;

    public ApplicationService(ProductsRepository productsRepository, UserRepository userRepository,
            PasswordEncoder bCryptEncoder) {
        this.productsRepository = productsRepository;
        this.userRepository = userRepository;
        this.bCryptEncoder = bCryptEncoder;
    }

    public Products itemDescription(Integer id) {
        Products item = productsRepository.findById(id).orElseThrow();
        return item;
    }

    public boolean registerUser(User user) {
        if (user.getEmail().isEmpty() || user.getUsername().isEmpty() || user.getPassword().isEmpty()
            || user.getFirstname().isEmpty() || user.getLastname().isEmpty()) {
            return false;
        } else {
            String encryptedPassword = bCryptEncoder.encode(user.getPassword());
            user.setPassword(encryptedPassword);

            userRepository.save(user);
            return true;
        }
    }

}
