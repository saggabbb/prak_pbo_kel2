package com.example.setorsampah.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.setorsampah.model.User;
import com.example.setorsampah.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final UserRepository userRepository;
    
    public User createUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        return userRepository.save(user);
    }
    
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
    
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    public User updateUser(Long id, User userDetails) {
        return userRepository.findById(id).map(user -> {
            user.setNama(userDetails.getNama());
            user.setAlamat(userDetails.getAlamat());
            user.setRole(userDetails.getRole());
            user.setEmail(userDetails.getEmail());
            user.setPassword(userDetails.getPassword());
            user.setPoint(userDetails.getPoint());
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }
    
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    
    public User addPoint(Long id, Double point) {
        return userRepository.findById(id).map(user -> {
            user.setPoint(user.getPoint() + point);
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }
}
