package com.test.reservation_system_backend.controller;

import com.test.reservation_system_backend.entity.User;
import com.test.reservation_system_backend.repository.UserRepository;
import com.test.reservation_system_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User registeredUser = userService.registerUser(user);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody User user) {
        boolean isAuthenticated = userService.authenticateUser(user.getUsername(), user.getPassword());
        if (isAuthenticated) {
            Optional<User> userLogin = userService.findByUsername(user.getUsername());
            return ResponseEntity.ok(userLogin.get());
        } else {
            return ResponseEntity.status(401).body(null);
        }
    }
}
