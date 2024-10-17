package com.example.coursemanagementapp.dao;

import com.example.backendcoreservice.api.pagination.PaginationRequest;
import com.example.backendcoreservice.dao.AbstractDao;
import com.example.coursemanagementapp.dao.repo.CourseRepo;
import com.example.coursemanagementapp.dto.CourseSearchDto;
import com.example.coursemanagementapp.model.Course;
import org.springframework.data.domain.Page;

public interface CourseDao extends AbstractDao<Course, CourseRepo> {

    Page<Course> findAllPaginatedAndFiltered(PaginationRequest<CourseSearchDto> paginationRequest);

    void updateCourseStatus(Long id, Long statusId);


}
