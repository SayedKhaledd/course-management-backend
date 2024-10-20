package com.example.coursemanagementapp.service;

import com.example.coursemanagementapp.dao.CourseLecturerDao;
import com.example.coursemanagementapp.dto.CourseLecturerDto;
import com.example.coursemanagementapp.dto.CourseLecturerHistoryDto;
import com.example.coursemanagementapp.model.CourseLecturer;
import com.example.coursemanagementapp.transformer.CourseLecturerTransformer;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class CourseLecturerServiceImpl implements CourseLecturerService {

    private final CourseLecturerDao courselecturerDao;
    private final CourseLecturerTransformer courselecturerTransformer;
    private final CourseService courseService;
    private final CourseLecturerHistoryService courseLecturerHistoryService;

    @Override
    public CourseLecturerDao getDao() {
        return courselecturerDao;
    }

    @Override
    public CourseLecturerTransformer getTransformer() {
        return courselecturerTransformer;
    }

    @SneakyThrows
    @Override
    public CourseLecturer doBeforeCreate(CourseLecturer entity, CourseLecturerDto dto) {
        log.info("CourseLecturerServiceImpl: doBeforeCreate() - was called");
        entity.setCourse(courseService.findEntityById(dto.getCourseId()));
        return entity;
    }

    @Override
    public List<CourseLecturerDto> findAllByCourseId(Long courseId) {
        log.info("CourseLecturerServiceImpl: findAllByCourseId() - was called");
        return getTransformer().transformEntitiesToDtos(getDao().findAllByCourseId(courseId));
    }

    @Transactional
    @Override
    public void updatePaidInPercentage(Long id, Boolean paidInPercentage) {
        log.info("CourseLecturerServiceImpl: updatePaidInPercentage() - was called");
        CourseLecturerDto courseLecturerDtoDb = findById(id);
        courseLecturerHistoryService.create(CourseLecturerHistoryDto.CourseLecturerHistoryDtoBuilder()
                .courseLecturer(courseLecturerDtoDb)
                .courseLecturerId(courseLecturerDtoDb.getId())
                .fieldName("paidInPercentage")
                .oldValue(courseLecturerDtoDb.getPaidInPercentage() + "")
                .newValue(paidInPercentage.toString())
                .build());
        getDao().updatePaidInPercentage(id, paidInPercentage);
    }


    @Transactional
    @Override
    public void updatePercentage(Long id, CourseLecturerDto dto) {
        log.info("CourseLecturerServiceImpl: updatePercentage() - was called");
        CourseLecturerDto courseLecturerDtoDb = findById(id);
        courseLecturerHistoryService.create(CourseLecturerHistoryDto.CourseLecturerHistoryDtoBuilder()
                .courseLecturer(courseLecturerDtoDb)
                .courseLecturerId(courseLecturerDtoDb.getId())
                .fieldName("percentage")
                .oldValue(courseLecturerDtoDb.getPercentage() + "")
                .newValue(dto.getPercentage().toString())
                .build());
        getDao().updatePercentage(id, dto.getPercentage());
    }


    @Transactional
    @Override
    public void updateFixedValue(Long id, CourseLecturerDto dto) {
        log.info("CourseLecturerServiceImpl: updateFixedValue() - was called");
        CourseLecturerDto courseLecturerDtoDb = findById(id);
        courseLecturerHistoryService.create(CourseLecturerHistoryDto.CourseLecturerHistoryDtoBuilder()
                .courseLecturer(courseLecturerDtoDb)
                .courseLecturerId(courseLecturerDtoDb.getId())
                .fieldName("fixedValue")
                .oldValue(courseLecturerDtoDb.getFixedValue() + "")
                .newValue(dto.getFixedValue().toString())
                .build());
        getDao().updateFixedValue(id, dto.getFixedValue());

    }
}
