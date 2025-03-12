package com.byui.studentstaffcommunication;

import com.byui.studentstaffcommunication.model.User;
import com.byui.studentstaffcommunication.model.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class StudentStaffCommunicationApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentStaffCommunicationApplication.class, args);
    }

    @Component
    public static class DatabaseSeeder implements CommandLineRunner {

        private final UserRepository userRepository;

        public DatabaseSeeder(UserRepository userRepository) {
            this.userRepository = userRepository;
        }

        @Override
        public void run(String... args) {
            if (userRepository.count() == 0) { // Prevent duplicate seeding
                User user1 = new User();
                user1.setEmail("user1@example.com");
                user1.setUsername("user1");

                userRepository.save(user1);

                System.out.println("Database seeded!");
            } else {
                System.out.println("Database already seeded.");
            }
        }
    }

}
