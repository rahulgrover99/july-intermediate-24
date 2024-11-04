package com.example.bookmyshow.controller;

import com.example.bookmyshow.dtos.SignUpRequestDto;
import com.example.bookmyshow.models.User;
import com.example.bookmyshow.service.UserService;
import org.springframework.security.authorization.method.HandleAuthorizationDenied;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("register")
    public @ResponseBody User signUp(@RequestBody SignUpRequestDto signUpRequestDto) {
        return userService.signUp(signUpRequestDto.getEmail(), signUpRequestDto.getPassword());
    }

    @GetMapping("login")
    public boolean login(@RequestBody SignUpRequestDto requestDto) {
        return userService.login(requestDto.getEmail(), requestDto.getPassword());
    }
}
