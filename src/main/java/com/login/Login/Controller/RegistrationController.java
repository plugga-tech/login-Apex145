package com.login.Login.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.login.Login.User.User;



@Controller
public class RegistrationController {
   
@GetMapping("/registration")
public String getRegistrationForm(Model model) {
    model.addAttribute("user", new User());
    return "registration";
}

@PostMapping("/registration")
public String postRegistrationForm(Model model) {
    
    return "redirect:/";
}




}
