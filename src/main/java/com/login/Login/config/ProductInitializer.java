package com.login.Login.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.login.Login.Model.Product.Products;
import com.login.Login.Repository.ProductsRepository;

@Configuration
public class ProductInitializer {

// This creates 3 products that gets stored to the datebase when the springboot application is started.
// This code is taken from https://medium.com/@AlexanderObregon/the-mechanics-of-spring-boots-commandlinerunner-d000be905133
// And includes minor tweaks.
@Bean
CommandLineRunner initProductDatabase(ProductsRepository productsRepository) {
    return args -> {
        if(productsRepository.count() == 0) {
            productsRepository.save(new Products("keyboard.jpg", "Nebula RGB Mechanical Keyboard", 1299.0, "A full mechanical keyboard with RGB"));
            productsRepository.save(new Products("mouse.jpg", "SwiftCursor Wireless G-Series", 799.0, "A very light gaming mouse with up to 80 hours of battery"));
            productsRepository.save(new Products("headphones.jpg", "SonicWave ANC Headphones", 2450.0, "Gamingheadphones with high quality sound and noise cancelling"));
        }
    };
}
    
}
