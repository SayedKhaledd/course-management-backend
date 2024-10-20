package com.example.coursemanagementapp.dao;

import com.example.backendcoreservice.api.pagination.PaginationRequest;
import com.example.coursemanagementapp.config.AuditAwareImpl;
import com.example.coursemanagementapp.dao.repo.CourseRepo;
import com.example.coursemanagementapp.dto.CourseSearchDto;
import com.example.coursemanagementapp.model.Course;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class CourseDaoImpl implements CourseDao {

    private final CourseRepo courseRepo;
    @Qualifier("auditAwareImpl")
    private final AuditAwareImpl auditAware;

    @Override
    public CourseRepo getRepo() {
        return courseRepo;
    }

    //TODO: Implement this method
    @Override
    public Page<Course> findAllPaginatedAndFiltered(PaginationRequest<CourseSearchDto> paginationRequest) {
        CourseSearchDto criteria = paginationRequest.getCriteria();
        Boolean markedAsDeleted = paginationRequest.getDeletedRecords();
        if (criteria == null)
            return getRepo().findAllByMarkedAsDeleted(getPageRequest(paginationRequest), markedAsDeleted);

//        return getRepo().findAllFilteredAndPaginated(getPageRequest(paginationRequest), criteria, markedAsDeleted);
        return null;
    }

    @Override
    public void updateCourseStatus(Long id, Long statusId) {
        log.info("CourseDao: updateCourseStatus() - was called with id: {} and statusId: {}", id, statusId);
        getRepo().updateCourseStatus(id, statusId);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updateName(Long id, String name) {
        log.info("CourseDao: updateName() - was called");
        getRepo().updateName(id, name);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updatePrice(Long id, Double price) {
        log.info("CourseDao: updatePrice() - was called");
        getRepo().updatePrice(id, price);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updatePart(Long id, String part) {
        log.info("CourseDao: updatePart() - was called");
        getRepo().updatePart(id, part);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());

    }

    @Override
    public void updateCode(Long id, String code) {
        log.info("CourseDao: updateCode() - was called");
        getRepo().updateCode(id, code);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());

    }

    @Override
    public void updateDescription(Long id, String description) {
        log.info("CourseDao: updateDescription() - was called");
        getRepo().updateDescription(id, description);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());

    }

    @Override
    public void updateStartDate(Long id, LocalDateTime startDate) {
        log.info("CourseDao: updateStartDate() - was called");
        getRepo().updateStartDate(id, startDate);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());

    }

    @Override
    public void updateEndDate(Long id, LocalDateTime endDate) {
        log.info("CourseDao: updateEndDate() - was called");
        getRepo().updateEndDate(id, endDate);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());

    }
}
