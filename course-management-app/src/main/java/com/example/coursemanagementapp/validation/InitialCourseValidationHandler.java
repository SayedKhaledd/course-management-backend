package com.example.coursemanagementapp.validation;

import com.example.coursemanagementapp.dto.ParsedClient;
import com.example.coursemanagementapp.service.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Component
public class InitialCourseValidationHandler implements ValidationHandler {
    private final CourseService courseService;

    @Override
    public void validate(List<ParsedClient> parsedClients) {
        log.info("InitialCourseValidationHandler: validate() - called");
        parsedClients.forEach(client -> {
            if (client.getInitialCourse() != null && !client.getInitialCourse().isEmpty() && !courseService.existsByNameAndIsInitial(client.getInitialCourse())) {
                client.getErrors().put("initialCourse", "Initial course is not valid");
                client.setValid(false);
            }
        });
    }
}
