package com.example.springsecurityform.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping(path = "hello", produces = "text/html")
    public String hello() {
        return "Hello!";
    }

    @GetMapping(path = "success", produces = "text/html")
    public String success() {
        return "success!";
    }

    @GetMapping(path = "page1", produces = "text/html")
    public String page1() {
        return "page1";
    }
}
