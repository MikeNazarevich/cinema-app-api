package com.mikhail.controller;

import com.mikhail.model.User;
import com.mikhail.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/api/user/{id}")
    public Optional<User> findById(@PathVariable Long id) {
        return userService.findById(id);
    }
}
