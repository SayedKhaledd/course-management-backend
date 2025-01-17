package com.example.coursemanagementapp.dao;

import com.example.backendcoreservice.api.pagination.PaginationRequest;
import com.example.backendcoreservice.dao.EntityManagerDao;
import com.example.coursemanagementapp.config.AuditAwareImpl;
import com.example.coursemanagementapp.dao.repo.CourseRepo;
import com.example.coursemanagementapp.dto.search.CourseSearchDto;
import com.example.coursemanagementapp.model.Course;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@AllArgsConstructor
public class CourseDaoImpl implements CourseDao {

    private final CourseRepo courseRepo;
    @Qualifier("auditAwareImpl")
    private final AuditAwareImpl auditAware;

    private final EntityManagerDao entityManagerDao;

    @Override
    public CourseRepo getRepo() {
        return courseRepo;
    }

    @Override
    public List<Course> findAllCoursesNotInitial() {
        log.info("CourseDao: findAllCoursesNotInitial() - was called");
        return getRepo().findAllCoursesNotInitialAndOrderByName();
    }

    @Override
    public List<Course> findAllInitialCourses() {
        log.info("CourseDao: findAllInitialCourses() - was called");
        return getRepo().findAllInitialCoursesAndOrderByName();
    }

    @Override
    public Page<Course> findAllPaginatedAndFiltered(PaginationRequest<CourseSearchDto> paginationRequest) {
        CourseSearchDto criteria = paginationRequest.getCriteria();
        if (criteria == null)
            return getRepo().findAll(getPageRequest(paginationRequest));

        return getRepo().findAllFilteredAndPaginated(getPageRequest(paginationRequest), criteria);
    }

    @Override
    public void updateCourseStatus(Long id, Long statusId) {
        log.info("CourseDao: updateCourseStatus() - was called with id: {} and statusId: {}", id, statusId);
        entityManagerDao.updateQuery(Course.class.getSimpleName(), id, "courseStatusId", statusId, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updateName(Long id, String name) {
        log.info("CourseDao: updateName() - was called");
        entityManagerDao.updateQuery(Course.class.getSimpleName(), id, "name", name, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updatePrice(Long id, Double price) {
        log.info("CourseDao: updatePrice() - was called");
        entityManagerDao.updateQuery(Course.class.getSimpleName(), id, "price", price, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updatePart(Long id, String part) {
        log.info("CourseDao: updatePart() - was called");
        entityManagerDao.updateQuery(Course.class.getSimpleName(), id, "part", part, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updateCode(Long id, String code) {
        log.info("CourseDao: updateCode() - was called");
        entityManagerDao.updateQuery(Course.class.getSimpleName(), id, "code", code, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updateDescription(Long id, String description) {
        log.info("CourseDao: updateDescription() - was called");
        entityManagerDao.updateQuery(Course.class.getSimpleName(), id, "description", description, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updateStartDate(Long id, LocalDateTime startDate) {
        log.info("CourseDao: updateStartDate() - was called");
        entityManagerDao.updateQuery(Course.class.getSimpleName(), id, "startDate", startDate, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updateEndDate(Long id, LocalDateTime endDate) {
        log.info("CourseDao: updateEndDate() - was called");
        entityManagerDao.updateQuery(Course.class.getSimpleName(), id, "endDate", endDate, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }
}
