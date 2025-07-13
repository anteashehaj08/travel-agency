package com.example.travel_agency.controllers;

import com.example.travel_agency.entities.User;
import com.example.travel_agency.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "/users/register";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("user", new User());
        return "users/create-user";
    }

    @PostMapping("/register")
    public String processRegister(@ModelAttribute("user") User user) {
        userService.register(user);
        return "redirect:/user/register";
    }
}
