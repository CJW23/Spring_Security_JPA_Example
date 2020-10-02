package com.cjw.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjw.security.entity.User;
import com.cjw.security.service.ExService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ExController {
    private final ExService service;

    @GetMapping("/signUp")
    public String signUpForm() {
        return "signup";
    }

    @PostMapping("/signUp")
    public String signUp(User user) {
        user.setRole("USER");
        service.joinUser(user);
        log.info(user.getEmail());
        return "redirect:/login";
    }

    @GetMapping("/")
    public String userAccess() {
    	return "user_access";
    }
}
