package com.example.coursemanagementapp.service;

import com.example.backendcoreservice.service.AbstractService;
import com.example.coursemanagementapp.dao.CourseDao;
import com.example.coursemanagementapp.dto.CourseDto;
import com.example.coursemanagementapp.model.Course;
import com.example.coursemanagementapp.transformer.CourseTransformer;

public interface CourseService extends AbstractService<Course, CourseDto, CourseTransformer, CourseDao> {

}
