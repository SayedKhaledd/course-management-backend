package com.example.coursemanagementapp.service;

import com.example.backendcoreservice.api.pagination.PaginationRequest;
import com.example.backendcoreservice.api.pagination.PaginationResponse;
import com.example.backendcoreservice.service.AbstractService;
import com.example.coursemanagementapp.dao.CourseDao;
import com.example.coursemanagementapp.dto.CourseDto;
import com.example.coursemanagementapp.dto.CourseSearchDto;
import com.example.coursemanagementapp.model.Course;
import com.example.coursemanagementapp.transformer.CourseTransformer;
import jakarta.validation.Valid;

public interface CourseService extends AbstractService<Course, CourseDto, CourseTransformer, CourseDao> {

    PaginationResponse<CourseDto> findAllPaginatedAndFiltered(@Valid PaginationRequest<CourseSearchDto> paginationRequest);

    void updateStatus(Long id, Long statusId);

}
