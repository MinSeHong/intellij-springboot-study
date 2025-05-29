package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExampleController {

    @GetMapping("/example")
    public String hello(Model model) {

        model.addAttribute("greeting", "Hello 타임리프.^^");
        return "example";
    }
}