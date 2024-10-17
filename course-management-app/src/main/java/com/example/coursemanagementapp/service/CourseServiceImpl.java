package com.example.coursemanagementapp.service;

import com.example.backendcoreservice.api.pagination.PaginationRequest;
import com.example.backendcoreservice.api.pagination.PaginationResponse;
import com.example.backendcoreservice.exception.CustomException;
import com.example.coursemanagementapp.dao.CourseDao;
import com.example.coursemanagementapp.dto.CourseDto;
import com.example.coursemanagementapp.dto.CourseSearchDto;
import com.example.coursemanagementapp.model.Course;
import com.example.coursemanagementapp.transformer.CourseTransformer;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseDao courseDao;
    private final CourseTransformer courseTransformer;
    private final CourseStatusService courseStatusService;

    @Override
    public CourseDao getDao() {
        return courseDao;
    }

    @Override
    public CourseTransformer getTransformer() {
        return courseTransformer;
    }

    @SneakyThrows
    @Override
    public Course doBeforeCreate(Course entity, CourseDto dto) {
        entity.setCourseStatus(courseStatusService.findEntityById(dto.getCourseStatusId()));
        return entity;
    }

    @Override
    public List<CourseDto> findAll() {
        log.info("data is "+getDao().findAll());
        return getTransformer().transformEntitiesToDtos(getDao().findAll());

    }

    @Override
    public PaginationResponse<CourseDto> findAllPaginatedAndFiltered(PaginationRequest<CourseSearchDto> paginationRequest) {
        log.info("CourseService: findAllPaginatedAndFiltered() - was called");
        return buildPaginationResponse(getDao().findAllPaginatedAndFiltered(paginationRequest));
    }

    @Transactional
    @Override
    public void updateStatus(Long id, Long statusId) {
        log.info("CourseService: updateStatus() - was called with id: {} and statusId: {}", id, statusId);
        if (!existsById(id))
            throw new CustomException("Course with id " + id + " does not exist");

        getDao().updateCourseStatus(id, statusId);
    }
}
