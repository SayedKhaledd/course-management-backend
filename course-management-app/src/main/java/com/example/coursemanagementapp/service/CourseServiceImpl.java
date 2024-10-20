package com.example.coursemanagementapp.service;

import com.example.backendcoreservice.api.pagination.PaginationRequest;
import com.example.backendcoreservice.api.pagination.PaginationResponse;
import com.example.coursemanagementapp.dao.CourseDao;
import com.example.coursemanagementapp.dto.CourseDto;
import com.example.coursemanagementapp.dto.CourseHistoryDto;
import com.example.coursemanagementapp.dto.CourseSearchDto;
import com.example.coursemanagementapp.enums.CourseStatus;
import com.example.coursemanagementapp.model.Course;
import com.example.coursemanagementapp.transformer.CourseTransformer;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseDao courseDao;
    private final CourseTransformer courseTransformer;
    private final CourseStatusService courseStatusService;
    private final CourseHistoryService courseHistoryService;

    @Override
    public CourseDao getDao() {
        return courseDao;
    }

    @Override
    public CourseTransformer getTransformer() {
        return courseTransformer;
    }

    @Override
    public Course doBeforeCreate(Course entity, CourseDto dto) {
        entity.setCourseStatus(courseStatusService.findEntityByStatus(CourseStatus.NOT_STARTED));
        return entity;
    }

    @Override
    public PaginationResponse<CourseDto> findAllPaginatedAndFiltered(PaginationRequest<CourseSearchDto> paginationRequest) {
        log.info("CourseService: findAllPaginatedAndFiltered() - was called");
        return buildPaginationResponse(getDao().findAllPaginatedAndFiltered(paginationRequest));
    }

    @Transactional
    @Override
    public void updateName(Long id, CourseDto dto) {
        log.info("CourseService: updateName() - was called");
        CourseDto courseDtoDb = findById(id);
        courseHistoryService.create(CourseHistoryDto.CourseHistoryDtoBuilder()
                .course(courseDtoDb)
                .courseId(courseDtoDb.getId())
                .fieldName("name")
                .oldValue(courseDtoDb.getName())
                .newValue(dto.getName())
                .build());
        getDao().updateName(id, dto.getName());
    }

    @Transactional

    @Override
    public void updateCode(Long id, CourseDto dto) {
        log.info("CourseService: updateCode() - was called");
        CourseDto courseDtoDb = findById(id);
        courseHistoryService.create(CourseHistoryDto.CourseHistoryDtoBuilder()
                .course(courseDtoDb)
                .courseId(courseDtoDb.getId())
                .fieldName("code")
                .oldValue(courseDtoDb.getCode())
                .newValue(dto.getCode())
                .build());
        getDao().updateCode(id, dto.getCode());

    }

    @Transactional

    @Override
    public void updateDescription(Long id, CourseDto dto) {
        log.info("CourseService: updateDescription() - was called");
        CourseDto courseDtoDb = findById(id);
        courseHistoryService.create(CourseHistoryDto.CourseHistoryDtoBuilder()
                .course(courseDtoDb)
                .courseId(courseDtoDb.getId())
                .fieldName("description")
                .oldValue(courseDtoDb.getDescription())
                .newValue(dto.getDescription())
                .build());
        getDao().updateDescription(id, dto.getDescription());

    }

    @Transactional

    @Override
    public void updatePrice(Long id, CourseDto dto) {
        log.info("CourseService: updatePrice() - was called");
        CourseDto courseDtoDb = findById(id);
        courseHistoryService.create(CourseHistoryDto.CourseHistoryDtoBuilder()
                .course(courseDtoDb)
                .courseId(courseDtoDb.getId())
                .fieldName("price")
                .oldValue(courseDtoDb.getPrice() + "")
                .newValue(dto.getPrice() + "")
                .build());
        getDao().updatePrice(id, dto.getPrice());

    }

    @Transactional

    @Override
    public void updatePart(Long id, CourseDto dto) {
        log.info("CourseService: updatePart() - was called");
        CourseDto courseDtoDb = findById(id);
        courseHistoryService.create(CourseHistoryDto.CourseHistoryDtoBuilder()
                .course(courseDtoDb)
                .courseId(courseDtoDb.getId())
                .fieldName("part")
                .oldValue(courseDtoDb.getPart())
                .newValue(dto.getPart())
                .build());
        getDao().updatePart(id, dto.getPart());

    }

    @Transactional

    @Override
    public void updateStartDate(Long id, CourseDto dto) {
        log.info("CourseService: updateStartDate() - was called");
        CourseDto courseDtoDb = findById(id);
        courseHistoryService.create(CourseHistoryDto.CourseHistoryDtoBuilder()
                .course(courseDtoDb)
                .courseId(courseDtoDb.getId())
                .fieldName("start date")
                .oldValue(courseDtoDb.getStartDate() + "")
                .newValue(dto.getStartDate().toString())
                .build());
        getDao().updateStartDate(id, dto.getStartDate());

    }

    @Transactional
    @Override
    public void updateEndDate(Long id, CourseDto dto) {
        log.info("CourseService: updateEndDate() - was called");
        CourseDto courseDtoDb = findById(id);
        courseHistoryService.create(CourseHistoryDto.CourseHistoryDtoBuilder()
                .course(courseDtoDb)
                .courseId(courseDtoDb.getId())
                .fieldName("end date")
                .oldValue(courseDtoDb.getEndDate() + "")
                .newValue(dto.getEndDate().toString())
                .build());
        getDao().updateEndDate(id, dto.getEndDate());

    }


    @Transactional
    @Override
    public void updateCourseStatus(Long id, Long courseStatusId) {
        log.info("CourseService: updateCourseStatus() - was called");
        if (!courseStatusService.existsById(courseStatusId)) {
            throw new EntityNotFoundException("Course status with id " + courseStatusId + " does not exist");
        }
        CourseDto courseDtoDb = findById(id);
        courseHistoryService.create(CourseHistoryDto.CourseHistoryDtoBuilder()
                .course(courseDtoDb)
                .courseId(courseDtoDb.getId())
                .fieldName("course status")
                .oldValue(courseDtoDb.getCourseStatus() == null ? "" : courseDtoDb.getCourseStatus().getStatus().getStatus())
                .newValue(courseStatusService.findById(courseStatusId).getStatus().toString())
                .build());
        getDao().updateCourseStatus(id, courseStatusId);

    }
}
