package com.parla.controller;

import com.parla.auth.jwt.TokenUtils;
import com.parla.pojo.AuthToken;
import com.parla.pojo.User;
import com.parla.pojo.front.LoginUser;
import com.parla.service.UserService;
import com.parla.service.UserValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController()
@RequestMapping("/token")
public class AuthController {

    @GetMapping("/")
    public Principal user(Principal user) {
        return user;
    }

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenUtils jwtTokenUtil;

    @Autowired
    UserValidationService userValidationService;

    @Autowired
    UserService userService;


    @PostMapping(value = "/generate-token", consumes = MediaType.APPLICATION_JSON_VALUE)
    public AuthToken login(@RequestBody LoginUser loginUser) throws AuthenticationException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        return new AuthToken(token);
    }

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void register(@RequestBody User user) {
//        if (!ValidationStatus.OK.equals(userValidationService.validateUser(user))) {
//            return;
//        }
        userService.save(user);
    }

}

