package com.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestRestController {
    private String restString = "Rest Controller";

    @GetMapping("rest")
    public String restController() {
        return restString;
    }
}
