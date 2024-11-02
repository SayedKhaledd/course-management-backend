package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.dao.repo.CourseStatusRepo;
import com.example.coursemanagementapp.model.CourseStatus;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CourseStatusDaoImpl implements CourseStatusDao {

    private final CourseStatusRepo coursestatusRepo;

    @Override
    public CourseStatusRepo getRepo() {
        return coursestatusRepo;
    }

    @Override
    public CourseStatus findByStatus(com.example.coursemanagementapp.enums.CourseStatus status) {
        log.info("CourseStatusDao: findByStatus() - was called");
        return getRepo().findByStatus(status);
    }
}
