package com.javaserver.server.users.service;

import com.javaserver.server.users.model.UserModel;
import com.javaserver.server.users.repository.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<UserModel> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public UserModel postUser(UserModel user) {
        return userRepository.save(user);
    }

    public Boolean deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public UserModel patchById(@NotNull UserModel request, Long id) { // this method only will change secure data
        UserModel user = userRepository.findById(id).get();
        user.setName(request.getName());
        user.setLastname(request.getLastname());
        user.setUserName(request.getUserName());
        user.setEmail(request.getEmail());

        return user;
    }
}

