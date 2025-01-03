package com.example.pockettrack.web.controller;

import com.example.pockettrack.model.User;
import com.example.pockettrack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        System.out.println("UserController is instantiated!");
        this.userService = userService;
    }

    @GetMapping("/test")
    public String testEndpoint() {

        return "UserController is working!";
    }


    @GetMapping("/{id}/balance")
    public double getUserBalance(@PathVariable Long id){
        User user = userService.findById(id);
        if (user == null) {
            throw new RuntimeException("User not found with ID: " + id);
        }
        return user.getBalance();
    }

    @PutMapping("/{id}/balance")
    public User updateUserBalance(@PathVariable Long id,@RequestBody double newBalance){
        return userService.updateUserBalance(id,newBalance);
    }

    @PostMapping("/register")
    public User register(@RequestBody User user)
    {
        System.out.println("Received request to register user: " + user.getUsername());
        return userService.registerUser(user);
    }
    @GetMapping("/{username}")
    public Optional<User> findByUsername(@PathVariable String username)
    {
        return userService.findByUsername(username);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id)
    {
        userService.deleteUser(id);
    }

}
