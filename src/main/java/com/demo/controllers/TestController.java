package com.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class TestController {

    @GetMapping
    public String printWelcome(ModelMap model) {
        String messages = "Hello Docker!!!!!";
        model.addAttribute("messages", messages);
        return "helloDocker";
    }
}
