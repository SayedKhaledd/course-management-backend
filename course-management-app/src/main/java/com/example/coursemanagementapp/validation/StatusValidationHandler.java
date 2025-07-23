package com.example.coursemanagementapp.validation;

import com.example.coursemanagementapp.dto.ParsedClient;
import com.example.coursemanagementapp.service.ClientStatusService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Component
public class StatusValidationHandler implements ValidationHandler {
    private final ClientStatusService clientStatusService;


    @Override
    public void validate(List<ParsedClient> parsedClients) {
        log.info("StatusValidationHandler: validate() - called");
        parsedClients.forEach(client -> {
            if (client.getStatus() != null && !client.getStatus().isEmpty() && !clientStatusService.existsByName(client.getStatus())) {
                client.getErrors().put("status", "Status is not valid");
                client.setValid(false);
            }
        });
    }
}
