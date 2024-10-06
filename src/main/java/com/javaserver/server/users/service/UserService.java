package com.javaserver.server.users.service;

import com.javaserver.server.users.UserDto.UserDto;
import com.javaserver.server.users.model.UserModel;
import com.javaserver.server.users.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    //Getters
    // get all users
    public List<UserDto> getAllUsers() {
        List<UserModel> users = userRepository.findAll();
        return users.stream()
                .map(user -> new UserDto(user.getId(), user.getUserName(), user.getName(), user.getLastname()))
                .collect(Collectors.toList());
    }

    //get by id
    public Optional<UserDto> getUserById(final Long id) {
        Optional<UserModel> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new EntityNotFoundException("User whit id " + id + "not Founded: 404");
        }
        UserModel userDB = user.get();
        return Optional.of(new UserDto(userDB.getId(), userDB.getUserName(), userDB.getName(), userDB.getLastname()));
    }

    public UserModel postUser(UserModel user) {
        return userRepository.save(user);
    }

    public Integer deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
            return 200;
        } catch (Exception e) {
            System.out.println(e);
            return 401;
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

    public UserModel patchPassword(@NotNull UserModel request, Long id) { // This Method only change password
        UserModel user = userRepository.findById(id).get();
        user.setPassword(request.getPassword());
        return user;
    }

    public boolean Auth() {
        return false;
    }
}

