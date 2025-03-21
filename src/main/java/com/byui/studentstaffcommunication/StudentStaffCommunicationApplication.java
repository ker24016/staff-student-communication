package com.byui.studentstaffcommunication;

import com.byui.studentstaffcommunication.model.Post;
import com.byui.studentstaffcommunication.model.User;
import com.byui.studentstaffcommunication.repository.PostRepository;
import com.byui.studentstaffcommunication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class StudentStaffCommunicationApplication {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(StudentStaffCommunicationApplication.class, args);
    }

    @Bean
    public CommandLineRunner seedDatabase() {
        return args -> {
            if (userRepository.count() == 0) {
                User user1 = new User("User1", "", new ArrayList<>());
                userRepository.save(user1);
                if (postRepository.count() == 0) {
                    postRepository.save(new Post("Hello, World!", "This is a test post.", user1, null, new ArrayList<>()));
                }
            } else {
                if (postRepository.count() == 0) {
                    postRepository.save(new Post("Hello, World!", "This is a test post.", null, null, new ArrayList<>()));
                }
            }
        };
    }
}
