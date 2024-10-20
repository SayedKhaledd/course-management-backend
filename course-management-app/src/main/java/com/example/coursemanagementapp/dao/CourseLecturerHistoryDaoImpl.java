package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.dao.repo.CourseLecturerHistoryRepo;
import com.example.coursemanagementapp.model.CourseLecturerHistory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class CourseLecturerHistoryDaoImpl implements CourseLecturerHistoryDao {

    private final CourseLecturerHistoryRepo courselecturerhistoryRepo;

    @Override
    public CourseLecturerHistoryRepo getRepo() {
        return courselecturerhistoryRepo;
    }

    @Override
    public List<CourseLecturerHistory> findAllByCourseLecturerIdAndFieldName(Long courseLecturerId, String fieldName) {
        log.info("CourseLecturerHistoryDaoImpl: findAllByCourseLecturerIdAndFieldName() called");
        return getRepo().findAllByCourseLecturerIdAndFieldName(courseLecturerId, fieldName);
    }
}
