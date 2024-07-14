package com.bravuthon.skillmatrix.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/pub/test")
public class TestController {

    @GetMapping("/getTest")
    public ResponseEntity<?> getTest() {
        return ResponseEntity.ok("ok test");
    }
}
