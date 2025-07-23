package com.example.coursemanagementapp.validation;

import com.example.coursemanagementapp.dao.ClientDao;
import com.example.coursemanagementapp.dto.ParsedClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Slf4j
@Component
public class DatabaseValidationHandler implements ValidationHandler {
    private final ClientDao clientDao;

    @Override
    public void validate(List<ParsedClient> parsedClients) {
        log.info("DatabaseValidationHandler: validate() - called");
        Set<String> clientsPhoneNumberDB = new HashSet<>(clientDao.findAllClientsPhoneNumbers());
        Set<String> clientsAlternativePhoneNumberDB = new HashSet<>(clientDao.findAllClientsAlternativePhoneNumbers());
        Set<String> clientsEmailDB = new HashSet<>(clientDao.findAllClientsEmails());

        parsedClients.forEach(client -> {
            checkDatabaseUniqueness(client, clientsPhoneNumberDB, clientsAlternativePhoneNumberDB, clientsEmailDB);
        });
    }

    private void checkDatabaseUniqueness(ParsedClient client, Set<String> clientsPhoneNumberDB, Set<String> clientsAlternativePhoneNumberDB, Set<String> clientsEmailDB) {
        checkUniqueness(client, client.getPhone(), clientsPhoneNumberDB, "phone");
        checkUniqueness(client, client.getAlternativePhone(), clientsAlternativePhoneNumberDB, "alternativePhone");
        checkUniqueness(client, client.getEmail(), clientsEmailDB, "email");
    }

    private void checkUniqueness(ParsedClient client, String value, Set<String> databaseSet, String errorKey) {
        if (value != null && !value.isEmpty() && databaseSet.contains(value)) {
            String errorMessage = errorKey.substring(0, 1).toUpperCase() + errorKey.substring(1) + " is not unique, is duplicate with another client in the database";
            client.getErrors().merge(errorKey, errorMessage, (oldValue, newValue) -> oldValue + ", and is also duplicate with another client in the database");
            client.setValid(false);
        }
    }
}
