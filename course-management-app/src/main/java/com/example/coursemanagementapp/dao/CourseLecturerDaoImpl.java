package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.config.AuditAwareImpl;
import com.example.coursemanagementapp.dao.repo.CourseLecturerRepo;
import com.example.coursemanagementapp.model.CourseLecturer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@AllArgsConstructor
public class CourseLecturerDaoImpl implements CourseLecturerDao {

    private final CourseLecturerRepo courselecturerRepo;
    @Qualifier("auditAwareImpl")
    private final AuditAwareImpl auditAware;

    @Override
    public CourseLecturerRepo getRepo() {
        return courselecturerRepo;
    }

    @Override
    public List<CourseLecturer> findAllByCourseId(Long courseId) {
        log.info("CourseLecturerDao: findAllByCourseId() - was called");
        return getRepo().findAllByCourseId(courseId);
    }

    @Override
    public void updatePaidInPercentage(Long id, Boolean paidInPercentage) {
        log.info("CourseLecturerDao: updatePaidInPercentage() - was called");
        getRepo().updatePaidInPercentage(id, paidInPercentage);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updatePercentage(Long id, Double percentage) {
        log.info("CourseLecturerDao: updatePercentage() - was called");
        getRepo().updatePercentage(id, percentage);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updateFixedValue(Long id, Double fixedValue) {
        log.info("CourseLecturerDao: updateFixedValue() - was called");
        getRepo().updateFixedValue(id, fixedValue);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());

    }
}
