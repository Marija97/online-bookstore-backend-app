package com.mashasoftware.onlinebookstore.user.controller;

import com.mashasoftware.onlinebookstore.user.dto.UserRequestDto;
import com.mashasoftware.onlinebookstore.user.dto.UserResponseDto;
import com.mashasoftware.onlinebookstore.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public UserResponseDto createUser(@RequestBody @Valid UserRequestDto user) {
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public UserResponseDto getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }
}