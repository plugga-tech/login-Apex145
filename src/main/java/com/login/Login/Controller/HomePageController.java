package com.login.Login.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.login.Login.Repository.ProductsRepository;

@Controller
public class HomePageController {

    private final ProductsRepository productsRepository;

    public HomePageController(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @GetMapping("/")
    public String getHomePage(Model model) {
        model.addAttribute("products", productsRepository.findAll());
        return "index";
    }

}
