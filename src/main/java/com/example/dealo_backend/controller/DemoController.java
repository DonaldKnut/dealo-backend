package com.example.dealo_backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class DemoController {
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("Hello from Secure Endpoint");
    }
}
