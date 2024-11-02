package com.example.coursemanagementapp.dao;

import com.example.backendcoreservice.dao.AbstractDao;
import com.example.coursemanagementapp.dao.repo.CourseLecturerRepo;
import com.example.coursemanagementapp.model.CourseLecturer;

import java.util.List;

public interface CourseLecturerDao extends AbstractDao<CourseLecturer, CourseLecturerRepo> {

    List<CourseLecturer> findAllByCourseId(Long courseId);

    void updatePaidInPercentage(Long id, Boolean paidInPercentage);

    void updatePercentageAndTotalPercentageCost(Long id, Double percentage, Double totalPercentageCost);

    void updateNoOfLecturesAndTotalFixedCost(Long id, Long noOfLectures, Double totalFixedCost);

    void updateLectureCostAndTotalFixedCost(Long id, Double lectureCost, Double totalFixedCost);

}
