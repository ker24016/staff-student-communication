package com.byui.studentstaffcommunication.controller;

import com.byui.studentstaffcommunication.model.User;
import com.byui.studentstaffcommunication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public UserController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/me")
    public ResponseEntity<String> getSelf(Principal principal) {
        return ResponseEntity.ok(principal.getName());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userRepository.findById(id).orElse(null));
    }

    @GetMapping("/search")
    public ResponseEntity<List<User>> searchByName(@RequestParam String name,
                                                  @RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(userRepository.getAllByNameContainingIgnoreCase(name, Pageable.ofSize(size).withPage(page)));
    }

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody UserRequest userRequest) {
        User user = new User();
        user.setName(userRequest.name);
        user.setPassword(passwordEncoder.encode(userRequest.password));
        user.setRoles(Set.of("USER"));
        userRepository.save(user);
        return ResponseEntity.ok("User created.");
    }

    public static class UserRequest {
        public String name;
        public String password;
    }
}
