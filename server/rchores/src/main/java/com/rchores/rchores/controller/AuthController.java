package com.rchores.rchores.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rchores.rchores.models.User;

@RestController
@RequestMapping("/api")
public class AuthController {
    @PostMapping("/signup")
    public ResponseEntity<Map<String, String>> signup(@RequestBody User user){
        System.out.println("Received signup info" + user.getUsername());
        // TODO: Add user to DB
        Map<String, String> response = new HashMap<>();
            response.put("message", "Signup Received");
        return ResponseEntity.ok(response);
    }
}
