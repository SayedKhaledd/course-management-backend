package com.example.coursemanagementapp.dao;

import com.example.backendcoreservice.api.pagination.PaginationRequest;
import com.example.backendcoreservice.dao.AbstractDao;
import com.example.coursemanagementapp.dao.repo.CourseRepo;
import com.example.coursemanagementapp.dto.search.CourseSearchDto;
import com.example.coursemanagementapp.model.Course;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;

public interface CourseDao extends AbstractDao<Course, CourseRepo> {

    List<Course> findAllCoursesNotInitial();

    List<Course> findAllInitialCourses();

    Page<Course> findAllPaginatedAndFiltered(PaginationRequest<CourseSearchDto> paginationRequest);

    void updateCourseStatus(Long id, Long statusId);

    void updateName(Long id, String name);

    void updatePrice(Long id, Double price);

    void updatePart(Long id, String part);

    void updateCode(Long id, String code);

    void updateDescription(Long id, String description);

    void updateStartDate(Long id, LocalDateTime startDate);

    void updateEndDate(Long id, LocalDateTime endDate);

}
