package com.example.coursemanagementapp.dao;

import com.example.backendcoreservice.dao.AbstractDao;
import com.example.coursemanagementapp.dao.repo.CourseHistoryRepo;
import com.example.coursemanagementapp.model.CourseHistory;

import java.util.List;

public interface CourseHistoryDao extends AbstractDao<CourseHistory, CourseHistoryRepo> {

    List<CourseHistory> findAllByCourseIdAndFieldName(Long courseId, String fieldName);
}
