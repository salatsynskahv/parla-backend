package com.parla.controller;

import com.parla.pojo.User;
import com.parla.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userDetailsService;

    @GetMapping
    public User get(@RequestParam("username") String username) {
        return userDetailsService.findByUsername(username);
    }
}
