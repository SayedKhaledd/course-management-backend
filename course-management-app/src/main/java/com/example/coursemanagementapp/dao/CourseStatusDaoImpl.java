package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.dao.repo.CourseStatusRepo;
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


}
