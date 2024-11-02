package com.example.coursemanagementapp.service;

import com.example.backendcoreservice.service.AbstractService;
import com.example.coursemanagementapp.dao.CourseLecturerDao;
import com.example.coursemanagementapp.dto.CourseLecturerDto;
import com.example.coursemanagementapp.model.CourseLecturer;
import com.example.coursemanagementapp.transformer.CourseLecturerTransformer;

import java.util.List;

public interface CourseLecturerService extends AbstractService<CourseLecturer, CourseLecturerDto, CourseLecturerTransformer, CourseLecturerDao> {

    List<CourseLecturerDto> findAllByCourseId(Long courseId);

    void updatePaidInPercentage(Long id, Boolean paidInPercentage);

    void updatePercentageAndTotalPercentageCost(Long id, CourseLecturerDto dto);

    void updateNoOfLectures(Long id, CourseLecturerDto dto);

    void updateLectureCost(Long id, CourseLecturerDto dto);

}
