package com.example.coursemanagementapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@EnableMethodSecurity(jsr250Enabled = true, prePostEnabled = true)
@SpringBootApplication(scanBasePackages = "com.example.*")
public class CourseManagementAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseManagementAppApplication.class, args);
    }

}
