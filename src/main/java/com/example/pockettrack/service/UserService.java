package com.example.pockettrack.service;

import com.example.pockettrack.model.Transaction;
import com.example.pockettrack.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User registerUser(User user);

    Optional<User> findByUsername(String username);

    void deleteUser(Long id);

    double getUserBalance(Long id);

     User updateUserBalance(Long id, double newBalance);

    boolean validatePassword(User user, String rawPassword);

    User findById(Long id);


}
