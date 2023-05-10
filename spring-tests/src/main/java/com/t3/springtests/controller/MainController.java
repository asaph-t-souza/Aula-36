package com.t3.springtests.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/")
    public String mainPage() {
        return "Página Inicial";
    }

    @GetMapping("/welcome")
    public String welcome(@RequestParam(value = "name", defaultValue = "World") String name) {
        return ("Hello " + name);
    }

}
