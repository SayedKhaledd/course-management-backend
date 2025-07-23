package com.example.coursemanagementapp.validation;

import com.example.coursemanagementapp.dto.ParsedClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
public class PhoneValidationHandler implements ValidationHandler {


    @Override
    public void validate(List<ParsedClient> parsedClients) {
        log.info("PhoneValidationHandler: validate() - called");
        parsedClients.stream().forEach(client -> {
            if (client.getPhone() == null || client.getPhone().isEmpty()) {
                client.getErrors().put("phone", "Phone number is required");
                client.setValid(false);
            } else if (parsedClients.stream().filter(c -> c.getPhone().equals(client.getPhone())).count() > 1) {
                client.getErrors().put("phone", "Phone number is not unique, is duplicate with another client in the file");
                client.setValid(false);
            }
        });
    }
}
