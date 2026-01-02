package com.login.Login.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MyOrdersController {

    @GetMapping("/orders")
    public String getOrders(Authentication authentication) {
        if(authentication == null) {
            return "redirect:/";
        }else {
            return "orders";
        }
    }

}
