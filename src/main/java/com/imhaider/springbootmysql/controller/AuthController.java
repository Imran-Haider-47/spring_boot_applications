package com.imhaider.springbootmysql.controller;

import com.imhaider.springbootmysql.entity.User;
import com.imhaider.springbootmysql.enums.Role;
import com.imhaider.springbootmysql.security.JwtHelper;
import com.imhaider.springbootmysql.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtHelper jwtHelper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) throws Exception {
        Optional<User> existingUser = userService.getUser(user.getEmail());
        if(existingUser.isPresent()){
            // If authentication is successful, generate a JWT token
            String token = jwtHelper.generateToken(existingUser.get());

            // Return the JWT token in the response
            return ResponseEntity.ok(token);
        } else {
            throw new Exception("User details are incorrect.");
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody User user) throws Exception {
        // Check if user already exists (e.g., by username or email)
        Optional <User> existingUser = userService.getUser(user.getEmail());
        if (existingUser.isPresent()) {
            throw new Exception("User with this email already exists!");
        }
        // Create a new user entity with encoded password
        User newUser = new User();
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        newUser.setAge(user.getAge());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setRole((Role.USER));

        // Save the new user entity to the database (e.g., using a UserRepository)
        userService.createUser(newUser);

        // Return success message or status code in the response
        return ResponseEntity.ok("User registered successfully");
    }
}
