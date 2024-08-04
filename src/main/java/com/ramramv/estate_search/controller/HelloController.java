package com.ramramv.estate_search.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HelloController {
    @GetMapping("/hello")
    @PreAuthorize("hasRole('client_user')")
    public String getMethodName() {
        return "HELLO WORLD";
    }

}
