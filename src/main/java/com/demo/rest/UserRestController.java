package com.demo.rest;

import com.demo.dto.UserDto;
import com.demo.servise.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class UserRestController {

    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<Set<UserDto>>getUsers() {
        return ResponseEntity.ok(userService.getUsersDto());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDto>getUser(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }
}
