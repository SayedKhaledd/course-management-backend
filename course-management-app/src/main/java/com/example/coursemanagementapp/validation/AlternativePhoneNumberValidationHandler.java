package com.example.coursemanagementapp.validation;

import com.example.coursemanagementapp.dto.ParsedClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class AlternativePhoneNumberValidationHandler implements ValidationHandler {


    @Override
    public void validate(List<ParsedClient> parsedClients) {
        log.info("AlternativePhoneNumberValidationHandler: validate() - called");
        parsedClients.stream().forEach(client -> {
            if (client.getAlternativePhone() != null && !client.getAlternativePhone().isEmpty()) {
                if (parsedClients.stream().filter(c -> c.getAlternativePhone().equals(client.getAlternativePhone())).count() > 1) {
                    client.getErrors().put("alternativePhone", "Alternative phone number is not unique, is duplicate with another client in the file");
                    client.setValid(false);
                } else if (parsedClients.stream().filter(c -> c.getAlternativePhone().equals(client.getPhone())).count() > 0) {
                    client.getErrors().put("alternativePhone", "Alternative phone number is not unique, is duplicate with another client's phone number in the file");
                    client.setValid(false);
                }
            }

        });
    }
}
