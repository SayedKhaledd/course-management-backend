package com.example.coursemanagementapp.dao;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import com.example.coursemanagementapp.dao.repo.CourseStatusRepo;

@Component
@AllArgsConstructor
public class CourseStatusDaoImpl implements CourseStatusDao {

    private final CourseStatusRepo coursestatusRepo;

    @Override
    public CourseStatusRepo getRepo() {
        return coursestatusRepo;
    }


}
