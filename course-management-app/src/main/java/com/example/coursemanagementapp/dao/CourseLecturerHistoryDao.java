package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.model.CourseLecturerHistory;
import com.example.backendcoreservice.dao.AbstractDao;
import com.example.coursemanagementapp.dao.repo.CourseLecturerHistoryRepo;

import java.util.List;

public interface CourseLecturerHistoryDao extends AbstractDao<CourseLecturerHistory, CourseLecturerHistoryRepo> {

    List<CourseLecturerHistory> findAllByCourseLecturerIdAndFieldName(Long courseLecturerId, String fieldName);
}
