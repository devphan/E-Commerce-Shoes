package com.ecommerce.shoes.controller.admin;

import com.ecommerce.shoes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/admin/user")
    public String getListUser(Model model) {
        model.addAttribute("users", userService.findAll());
        return "admin/user/user";
    }
}
