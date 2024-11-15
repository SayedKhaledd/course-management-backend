package com.example.coursemanagementapp.dao;

import com.example.backendcoreservice.api.pagination.PaginationRequest;
import com.example.backendcoreservice.dao.AbstractDao;
import com.example.coursemanagementapp.dao.repo.CourseLecturerRepo;
import com.example.coursemanagementapp.dto.search.CourseLecturerSearchDto;
import com.example.coursemanagementapp.model.CourseLecturer;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CourseLecturerDao extends AbstractDao<CourseLecturer, CourseLecturerRepo> {

    List<CourseLecturer> findAllByCourseId(Long courseId);

    Page<CourseLecturer> findAllPaginatedAndFiltered(PaginationRequest<CourseLecturerSearchDto> paginationRequest);

    void updatePaidInPercentage(Long id, Boolean paidInPercentage);

    void updatePercentageAndTotalPercentageCost(Long id, Double percentage, Double totalPercentageCost);

    void updateNoOfLecturesAndTotalFixedCost(Long id, Long noOfLectures, Double totalFixedCost);

    void updateLectureCostAndTotalFixedCost(Long id, Double lectureCost, Double totalFixedCost);

}
