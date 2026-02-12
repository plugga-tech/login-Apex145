package com.login.Login.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.login.Login.Model.Product.Products;
import com.login.Login.Service.ApplicationService;

@Controller
public class DescriptionController {


    private final ApplicationService applicationService;

    public DescriptionController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }
    

    @GetMapping("/itemdescription/{id}")
    public String getItemDescription(@PathVariable Integer id, Model model) {
        Products item = applicationService.itemDescription(id);
        model.addAttribute("item", item);
        return "description";
    }

}
