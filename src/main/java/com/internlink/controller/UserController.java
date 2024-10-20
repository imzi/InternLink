package com.internlink.controller;

import com.internlink.dto.LoginDto;
import com.internlink.model.User;
import com.internlink.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(@RequestBody LoginDto user) {
        userService.login(user);
        return "login"; // Return the login view
    }
}
