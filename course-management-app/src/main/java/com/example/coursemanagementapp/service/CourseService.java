package com.example.coursemanagementapp.service;

import com.example.coursemanagementapp.model.Course;
import com.example.coursemanagementapp.dto.CourseDto;
import com.example.coursemanagementapp.transformer.CourseTransformer;
import com.example.coursemanagementapp.dao.CourseDao;
import com.example.backendcoreservice.service.AbstractService;

public interface CourseService extends AbstractService<Course, CourseDto, CourseTransformer, CourseDao> {

}
