package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.model.CourseHistory;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import com.example.coursemanagementapp.dao.repo.CourseHistoryRepo;

import java.util.List;

@Component
@AllArgsConstructor
public class CourseHistoryDaoImpl implements CourseHistoryDao {

    private final CourseHistoryRepo coursehistoryRepo;

    @Override
    public CourseHistoryRepo getRepo() {
        return coursehistoryRepo;
    }


    @Override
    public List<CourseHistory> findAllByCourseIdAndFieldName(Long courseId, String fieldName) {
        return getRepo().findAllByCourseIdAndFieldName(courseId, fieldName);
    }
}
