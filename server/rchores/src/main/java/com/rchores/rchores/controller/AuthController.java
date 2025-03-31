package com.rchores.rchores.controller;
@RestController
@RequestMapping("/api")
public class AuthController {
    public ResponseEntity<String> signup(@RequestBody User user){
        System.out.println("Received signup info" + user.getUsername());
        // TODO: Add user to DB
        return ResponseEntity.ok("Signup Received");
    }
}
