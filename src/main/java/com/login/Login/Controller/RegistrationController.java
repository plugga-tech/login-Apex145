package com.login.Login.Controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.login.Login.Model.User.User;
import com.login.Login.Repository.UserRepository;
import com.login.Login.Service.ApplicationService;

@Controller
public class RegistrationController {

    private final ApplicationService applicationService;

    public RegistrationController(UserRepository userRepository, PasswordEncoder bCryptEncoder,
        ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/registration")
    public String getRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String postRegistrationForm(Model model, User user) {
        if(applicationService.registerUser(user) == true) {
            return "redirect:/";
        } else {
            model.addAttribute("error", "You need to fill in all the fields");
            model.addAttribute("user", user);
            return "registration";
        }
    }
}
