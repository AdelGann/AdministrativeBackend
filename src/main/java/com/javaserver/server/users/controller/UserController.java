package com.javaserver.server.users.controller;

import com.javaserver.server.users.model.UserModel;
import com.javaserver.server.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping
    public List<UserModel> getAllUsers() {
        return this.userService.getAllUsers();
    }

    @GetMapping(path = "/{id}")
    public Optional<UserModel> getUserById(@PathVariable Long id) {
        return this.userService.getUserById(id);
    }

    @PostMapping
    public UserModel postUser(@RequestBody UserModel user) {
        return this.userService.postUser(user);
    }

    @PatchMapping(path = "/{id}")
    public UserModel patchUser(@RequestBody UserModel request, @PathVariable Long id) {
        return this.userService.patchById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteUser(@PathVariable Long id) {
        boolean ok = this.userService.deleteUser(id);
        if (ok) {
            return "User Deleted Successfully: 200 ok";
        } else {
            return "Something went wrong: 500 Internal Server Error";
        }
    }

}
