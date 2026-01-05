package com.login.Login.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.login.Login.Model.Product.Products;
import com.login.Login.Repository.ProductsRepository;

@Controller
public class DescriptionController {

    private final ProductsRepository productsRepository;

    public DescriptionController(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @GetMapping("/itemdescription/{id}")
    public String getItemDescription(@PathVariable Integer id, Model model) {
        Products item = productsRepository.findById(id).orElseThrow();
        model.addAttribute("item", item);
        return "description";
    }

}
