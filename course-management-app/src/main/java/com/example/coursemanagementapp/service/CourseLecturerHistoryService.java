package com.example.coursemanagementapp.service;

import com.example.coursemanagementapp.model.CourseLecturerHistory;
import com.example.coursemanagementapp.dto.CourseLecturerHistoryDto;
import com.example.coursemanagementapp.transformer.CourseLecturerHistoryTransformer;
import com.example.coursemanagementapp.dao.CourseLecturerHistoryDao;
import com.example.backendcoreservice.service.AbstractService;

import java.util.List;

public interface CourseLecturerHistoryService extends AbstractService<CourseLecturerHistory, CourseLecturerHistoryDto, CourseLecturerHistoryTransformer, CourseLecturerHistoryDao> {

    List<CourseLecturerHistoryDto> findAllByCourseLecturerIdAndFieldName(Long courseLecturerId, String fieldName);
}
