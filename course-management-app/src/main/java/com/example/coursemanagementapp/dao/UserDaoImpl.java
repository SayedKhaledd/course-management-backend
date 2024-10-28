package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.config.AuditAwareImpl;
import com.example.coursemanagementapp.dao.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class UserDaoImpl implements UserDao {
    @Qualifier("auditAwareImpl")
    private final AuditAwareImpl auditAware;
    private final UserRepo userRepo;

    @Override
    public UserRepo getRepo() {
        return userRepo;
    }

    @Override
    public void updateRole(Long id, String role) {
        log.info("UserDao: updateRole - was called with id: {} and role: {}", id, role);
        getRepo().updateRole(id, role);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updateFirstName(Long id, String firstName) {
        log.info("UserDao: updateFirstName - was called with id: {} and firstName: {}", id, firstName);
        getRepo().updateFirstName(id, firstName);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updateLastName(Long id, String lastName) {
        log.info("UserDao: updateLastName - was called with id: {} and lastName: {}", id, lastName);
        getRepo().updateLastName(id, lastName);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());

    }

    @Override
    public void updateEmail(Long id, String email) {
        log.info("UserDao: updateEmail - was called with id: {} and email: {}", id, email);
        getRepo().updateEmail(id, email);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());

    }

    @Override
    public void updatePhoneNumber(Long id, String phoneNumber) {
        log.info("UserDao: updatePhoneNumber - was called with id: {} and phoneNumber: {}", id, phoneNumber);
        getRepo().updatePhoneNumber(id, phoneNumber);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());

    }
}
