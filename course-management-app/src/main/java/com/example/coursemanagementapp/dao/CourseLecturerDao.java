package com.example.coursemanagementapp.dao;

import com.example.backendcoreservice.dao.AbstractDao;
import com.example.coursemanagementapp.dao.repo.CourseLecturerRepo;
import com.example.coursemanagementapp.model.CourseLecturer;

import java.util.List;

public interface CourseLecturerDao extends AbstractDao<CourseLecturer, CourseLecturerRepo> {

    void updatePaidInPercentage(Long id, Boolean paidInPercentage);

    void updatePercentage(Long id, Double percentage);

    void updateFixedValue(Long id, Double fixedValue);

    List<CourseLecturer> findAllByCourseId(Long courseId);
}
