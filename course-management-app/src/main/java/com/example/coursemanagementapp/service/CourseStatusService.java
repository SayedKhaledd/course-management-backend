package com.example.coursemanagementapp.service;

import com.example.backendcoreservice.service.AbstractService;
import com.example.coursemanagementapp.dao.CourseStatusDao;
import com.example.coursemanagementapp.dto.CourseStatusDto;
import com.example.coursemanagementapp.model.CourseStatus;
import com.example.coursemanagementapp.transformer.CourseStatusTransformer;

public interface CourseStatusService extends AbstractService<CourseStatus, CourseStatusDto, CourseStatusTransformer, CourseStatusDao> {

}
