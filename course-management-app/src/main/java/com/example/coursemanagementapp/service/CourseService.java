package com.example.coursemanagementapp.service;

import com.example.backendcoreservice.api.pagination.PaginationRequest;
import com.example.backendcoreservice.api.pagination.PaginationResponse;
import com.example.backendcoreservice.service.AbstractService;
import com.example.coursemanagementapp.dao.CourseDao;
import com.example.coursemanagementapp.dto.CourseDto;
import com.example.coursemanagementapp.dto.search.CourseSearchDto;
import com.example.coursemanagementapp.model.Course;
import com.example.coursemanagementapp.transformer.CourseTransformer;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Set;

public interface CourseService extends AbstractService<Course, CourseDto, CourseTransformer, CourseDao> {

    List<CourseDto> findAllCoursesNotInitial();

    List<CourseDto> findAllInitialCourses();

    PaginationResponse<CourseDto> findAllPaginatedAndFiltered(@Valid PaginationRequest<CourseSearchDto> paginationRequest);

    List<CourseDto> findAllInitialCoursesByNamesIn(Set<String> names);

    void updateName(Long id, CourseDto dto);

    void updateCode(Long id, CourseDto dto);

    void updateDescription(Long id, CourseDto dto);

    void updatePrice(Long id, CourseDto dto);

    void updateStartDate(Long id, CourseDto dto);

    void updateEndDate(Long id, CourseDto dto);

    void updateCourseStatus(Long id, Long courseStatusId);

    boolean existsByNameAndIsInitial(String initialCourse);
}
