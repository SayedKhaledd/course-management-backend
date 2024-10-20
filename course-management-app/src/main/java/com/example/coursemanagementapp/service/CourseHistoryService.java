package com.example.coursemanagementapp.service;

import com.example.backendcoreservice.service.AbstractService;
import com.example.coursemanagementapp.dao.CourseHistoryDao;
import com.example.coursemanagementapp.dto.CourseHistoryDto;
import com.example.coursemanagementapp.model.CourseHistory;
import com.example.coursemanagementapp.transformer.CourseHistoryTransformer;

import java.util.List;

public interface CourseHistoryService extends AbstractService<CourseHistory, CourseHistoryDto, CourseHistoryTransformer, CourseHistoryDao> {

    List<CourseHistoryDto> findAllByCourseIdAndFieldName(Long courseId, String fieldName);
}
