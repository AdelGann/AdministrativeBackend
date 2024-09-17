package com.javaserver.services31.service;

import com.javaserver.services31.model.UserModel;
import com.javaserver.services31.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }
    public Optional<UserModel> getUserById(Long id) {
        return userRepository.findById(id);
    }
}

