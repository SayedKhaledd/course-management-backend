package com.example.coursemanagementapp.service;

import com.example.backendcoreservice.service.AbstractService;
import com.example.coursemanagementapp.dao.CourseLecturerDao;
import com.example.coursemanagementapp.dto.CourseLecturerDto;
import com.example.coursemanagementapp.model.CourseLecturer;
import com.example.coursemanagementapp.transformer.CourseLecturerTransformer;

public interface CourseLecturerService extends AbstractService<CourseLecturer, CourseLecturerDto, CourseLecturerTransformer, CourseLecturerDao> {

}
