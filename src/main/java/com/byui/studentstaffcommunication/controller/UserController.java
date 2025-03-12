package com.byui.studentstaffcommunication.controller;

import com.byui.studentstaffcommunication.model.User;
import com.byui.studentstaffcommunication.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping(path="/add")
    public @ResponseBody String addUser(@RequestParam String name, @RequestParam String email) {
        User user = new User();
        user.setUsername(name);
        user.setEmail(email);
        userRepository.save(user);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }
}
