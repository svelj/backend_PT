package com.example.pockettrack.web.controller;


import com.example.pockettrack.model.User;
import com.example.pockettrack.model.dto.LoginRequest;
import com.example.pockettrack.model.dto.RegisterRequest;
import com.example.pockettrack.repository.UserRepository;
import com.example.pockettrack.service.impl.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationService authenticationService;

    @Autowired
    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public User login(@RequestBody LoginRequest loginRequest) {
        return authenticationService.authenticateUser(loginRequest.getUsername(), loginRequest.getPassword());
    }

    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest registerRequest) {
        return authenticationService.registerUser(registerRequest.getUsername(), registerRequest.getPassword());
    }
}


