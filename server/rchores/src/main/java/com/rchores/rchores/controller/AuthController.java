package com.rchores.rchores.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rchores.rchores.dto.LoginRequest;
import com.rchores.rchores.models.User;
import com.rchores.rchores.repository.UserRepository;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody User user){
        System.out.println("Received signup info" + user.getUsername());
        User savedUser = userRepository.save(user);       
        return ResponseEntity.ok(Map.of("message", "User created", "id", savedUser));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginInfo){
        Optional<User> optionalUser = userRepository.findByEmail(loginInfo.getEmail());

        if(optionalUser.isEmpty()){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Invalid email or password"));
        }
        User user = optionalUser.get();

        if(!user.getPassword().equals(loginInfo.getPassword())){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(Map.of("error","Invalid email or password"));
        }

        return ResponseEntity.ok(Map.of("message","Login successful",
        "userName", user.getName(),"email", user.getEmail() ));

    }
    
}
