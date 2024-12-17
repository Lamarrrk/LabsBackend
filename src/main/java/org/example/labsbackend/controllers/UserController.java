package org.example.labsbackend.controllers;

import org.example.labsbackend.models.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class UserController {
    private final Map<Long, User> users = new HashMap<>();

    @GetMapping("/user/{userId}")
    public User getUser(@PathVariable Long userId) {
        return users.getOrDefault(userId, null);
    }

    @PostMapping("/user")
    public String createUser(@RequestBody User user) {
        users.put(user.getId(), user);
        return "User created successfully!";
    }

    @DeleteMapping("/user/{userId}")
    public String deleteUser(@PathVariable Long userId) {
        users.remove(userId);
        return "User deleted successfully!";
    }

    @GetMapping("/users")
    public Collection<User> getAllUsers() {
        return users.values();
    }
}


