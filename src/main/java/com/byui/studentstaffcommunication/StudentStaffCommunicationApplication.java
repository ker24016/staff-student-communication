package com.byui.studentstaffcommunication;

import com.byui.studentstaffcommunication.model.Post;
import com.byui.studentstaffcommunication.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudentStaffCommunicationApplication {
    @Autowired
    private PostRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(StudentStaffCommunicationApplication.class, args);
    }

    @Bean
    public CommandLineRunner seedDatabase() {
        return args -> {
            if (repository.count() == 0) {
                repository.save(new Post("1", "Hello, World!", "This is a test post.", "1", null));
            }
        };
    }
}
