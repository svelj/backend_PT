package com.example.pockettrack.service.impl;

import com.example.pockettrack.model.User;
import com.example.pockettrack.repository.UserRepository;
import com.example.pockettrack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
       return userRepository.findAll().stream()
               .filter(c -> c.getUsername().equals(username))
               .findFirst();
    }

    @Override
    public double getUserBalance(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return user.getBalance();
    }

    @Override
    public User updateUserBalance(Long id, double newBalance) {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("User not found"));

        user.setBalance(newBalance);
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        userRepository.deleteById(id);
    }

    @Override
    public boolean validatePassword(User user, String rawPassword) {
        return user.getPassword().equals(rawPassword);
    }

    @Override
    public User findById(Long id) {
        return  userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));
    }
}
