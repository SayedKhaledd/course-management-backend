package com.example.coursemanagementapp.validation;

import com.example.coursemanagementapp.dto.ParsedClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class EmailValidationHandler implements ValidationHandler {

    @Override
    public void validate(List<ParsedClient> parsedClients) {
        log.info("EmailValidationHandler: validate() - called");
        parsedClients.forEach(client -> {
            String email = client.getEmail();
            if (email != null && !email.isEmpty() && parsedClients.stream().filter(c -> c.getEmail().equals(email)).count() > 1) {
                client.getErrors().put("email", "Email is not unique, is duplicate with another client in the file");
                client.setValid(false);
            }
        });
    }
}
