package com.example.coursemanagementapp.service;

import com.example.coursemanagementapp.model.CourseLecturer;
import com.example.coursemanagementapp.dto.CourseLecturerDto;
import com.example.coursemanagementapp.transformer.CourseLecturerTransformer;
import com.example.coursemanagementapp.dao.CourseLecturerDao;
import com.example.backendcoreservice.service.AbstractService;

public interface CourseLecturerService extends AbstractService<CourseLecturer, CourseLecturerDto, CourseLecturerTransformer, CourseLecturerDao> {

}
