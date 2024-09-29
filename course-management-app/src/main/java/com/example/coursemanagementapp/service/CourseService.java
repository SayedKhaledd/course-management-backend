package com.example.coursemanagementapp.service;

import com.example.backendcoreservice.service.AbstractService;
import com.example.coursemanagementapp.dao.CourseDao;
import com.example.coursemanagementapp.dto.CourseDto;
import com.example.coursemanagementapp.model.Course;
import com.example.coursemanagementapp.transformer.CourseTransformer;

import java.util.List;

public interface CourseService extends AbstractService<Course, CourseDto, CourseTransformer, CourseDao> {

    void updateStatus(Long id, Long statusId);
}
