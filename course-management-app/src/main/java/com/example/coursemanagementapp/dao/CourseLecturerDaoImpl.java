package com.example.coursemanagementapp.dao;

import com.example.backendcoreservice.api.pagination.PaginationRequest;
import com.example.coursemanagementapp.config.AuditAwareImpl;
import com.example.coursemanagementapp.dao.repo.CourseLecturerRepo;
import com.example.coursemanagementapp.dto.search.CourseLecturerSearchDto;
import com.example.coursemanagementapp.model.CourseLecturer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
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
    public Page<CourseLecturer> findAllPaginatedAndFiltered(PaginationRequest<CourseLecturerSearchDto> paginationRequest) {
        log.info("CourseLecturerDao: findAllPaginatedAndFiltered() - was called");
        CourseLecturerSearchDto criteria = paginationRequest.getCriteria();
        if (criteria == null)
            return getRepo().findAll(getPageRequest(paginationRequest));

        return getRepo().findAllFilteredAndPaginated(getPageRequest(paginationRequest), criteria);
    }

    @Override
    public void updatePaidInPercentage(Long id, Boolean paidInPercentage) {
        log.info("CourseLecturerDao: updatePaidInPercentage() - was called");
        getRepo().updatePaidInPercentage(id, paidInPercentage);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updatePercentageAndTotalPercentageCost(Long id, Double percentage, Double totalPercentageCost) {
        log.info("CourseLecturerDao: updatePercentage() - was called");
        getRepo().updatePercentageAndTotalPercentageCost(id, percentage, totalPercentageCost);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }


    @Override
    public void updateNoOfLecturesAndTotalFixedCost(Long id, Long noOfLectures, Double totalFixedCost) {
        log.info("CourseLecturerDao: updateNoOfLecturesAndTotalFixedCost() - was called");
        getRepo().updateNoOfLecturesAndTotalFixedCost(id, noOfLectures, totalFixedCost);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updateLectureCostAndTotalFixedCost(Long id, Double lectureCost, Double totalFixedCost) {
        log.info("CourseLecturerDao: updateLectureCostAndTotalFixedCost() - was called");
        getRepo().updateLectureCostAndTotalFixedCost(id, lectureCost, totalFixedCost);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }
}
