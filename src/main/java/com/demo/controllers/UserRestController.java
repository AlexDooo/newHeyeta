package com.demo.controllers;

import com.demo.dto.UserDto;
import com.demo.servise.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserRestController {

    private final UserService userService;

    @GetMapping
    public Set<UserDto> getUsers() {
        return userService.getUsersDto();
    }
}
