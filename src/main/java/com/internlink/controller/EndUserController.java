package com.internlink.controller;

import com.internlink.service.EndUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("test")
public class EndUserController {
    private final EndUserService userService;

    public EndUserController(EndUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/testUser")
    public String test(){
        userService.save();
        userService.test();
        return "sss";
    }
}
