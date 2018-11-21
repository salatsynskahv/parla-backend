package com.parla.controller;

import com.parla.pojo.User;
import com.parla.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    UserService userDetailsService;

    @GetMapping("/{username}/")
    public User get(@PathVariable() String username) {
        return userDetailsService.findByUsername(username);
    }
}
