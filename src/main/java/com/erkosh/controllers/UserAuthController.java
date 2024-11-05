package com.erkosh.controllers;

import com.erkosh.services.UserAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserAuthController {

    private final UserAuthService userAuthService;

    @GetMapping("/authenticate")
    public String isAuthenticated() {}

    @PostMapping("/authenticate")
    public String authenticate() {}
}
