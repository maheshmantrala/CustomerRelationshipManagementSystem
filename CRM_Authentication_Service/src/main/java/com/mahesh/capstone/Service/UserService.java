package com.mahesh.capstone.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mahesh.capstone.Entity.User;
import com.mahesh.capstone.Repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public User register(User user) throws Exception {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new Exception("User already exists");
        }
        return userRepository.save(user);
    }

    public User login(String username, String password) throws Exception {
        User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new Exception("User not found"));
        if (!user.getPassword().equals(password)) {
            throw new Exception("Invalid credentials");
        }
        return user;
    }

}