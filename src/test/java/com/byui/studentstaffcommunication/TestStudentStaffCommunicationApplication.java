package com.byui.studentstaffcommunication;

import org.springframework.boot.SpringApplication;

public class TestStudentStaffCommunicationApplication {

    public static void main(String[] args) {
        SpringApplication.from(StudentStaffCommunicationApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
