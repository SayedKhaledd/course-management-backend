package com.example.coursemanagementapp.validation;

import com.example.coursemanagementapp.dto.ParsedClient;
import com.example.coursemanagementapp.service.ReferralSourceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Component
public class ReferralSourceValidationHandler implements ValidationHandler {
    private final ReferralSourceService referralSourceService;


    @Override
    public void validate(List<ParsedClient> parsedClients) {
        log.info("ReferralSourceValidationHandler: validate() - called");
        parsedClients.forEach(client -> {
            if (client.getReferralSource() != null && !client.getReferralSource().isEmpty() && !referralSourceService.existsByName(client.getReferralSource())) {
                client.getErrors().put("referralSource", "Referral source is not valid");
                client.setValid(false);
            }
        });
    }
}
