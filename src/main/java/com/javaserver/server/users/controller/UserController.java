package com.javaserver.server.users.controller;

import com.javaserver.server.users.UserDto.UserDto;
import com.javaserver.server.users.model.UserModel;
import com.javaserver.server.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDto> getAllUsers() {
        return this.userService.getAllUsers();
    }

    @GetMapping(path = "/{id}")
    public Optional<UserDto> getUserById(@PathVariable final Long id) {
        return this.userService.getUserById(id);
    }

    @PostMapping // Doesn't Work
    public UserModel postUser(@RequestBody UserModel user) {
        return this.userService.postUser(user);
    }

    @PatchMapping(path = "/{id}")
    public UserModel patchUser(@RequestBody UserModel request, @PathVariable Long id) {
        return this.userService.patchById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteUser(@PathVariable Long id) {
        Integer ok = this.userService.deleteUser(id);
        return switch (ok) {
            case 200 -> "User removed successfully:";
            case 401 -> "User wasn't founded";
            default -> "Nothing to do yet";
        };
    }

}
