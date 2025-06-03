package com.DSE.FinalProject.service;

import com.DSE.FinalProject.model.User;
import com.DSE.FinalProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {


    @Autowired
    private UserRepository userRepository;

    public String authenticateUser(String email, String password) {
        // Use Optional to handle potential null values
        return userRepository.findByEmail(email)
                .filter(user -> user.getPassword().equals(password)) // Check password
                .map(User::getRole) // Get role if authenticated
                .orElse(null); // Return null if user not found or password doesn't match
    }

//    // Used for /api/login/token
//    public String getRoleByEmail(String email) {
//        return userRepository.findByEmail(email)
//                .map(User::getRole)
//                .orElse(null);
//    }

}

