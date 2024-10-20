package com.example.coursemanagementapp.dao;

import com.example.backendcoreservice.dao.AbstractDao;
import com.example.coursemanagementapp.dao.repo.CourseStatusRepo;
import com.example.coursemanagementapp.model.CourseStatus;

public interface CourseStatusDao extends AbstractDao<CourseStatus, CourseStatusRepo> {

    CourseStatus findByStatus(com.example.coursemanagementapp.enums.CourseStatus status);

}
