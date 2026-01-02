package com.login.Login.Controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.login.Login.Model.User.User;
import com.login.Login.Repository.UserRepository;

@Controller
public class RegistrationController {

    private final UserRepository userRepository;

    private final PasswordEncoder bCryptEncoder;

    public RegistrationController(UserRepository userRepository, PasswordEncoder bCryptEncoder) {
        this.userRepository = userRepository;
        this.bCryptEncoder = bCryptEncoder;
    }

    @GetMapping("/registration")
    public String getRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String postRegistrationForm(Model model, User user) {
        if (user.getEmail().isEmpty() || user.getUsername().isEmpty() || user.getPassword().isEmpty()
                || user.getFirstname().isEmpty() || user.getLastname().isEmpty()) {
            model.addAttribute("error", "You need to fill in all the fields");
            model.addAttribute("user", user);
            return "registration";
        } else {
            String encryptedPassword = bCryptEncoder.encode(user.getPassword());
            user.setPassword(encryptedPassword);
            userRepository.save(user);
        }
        return "redirect:/";
    }

}
