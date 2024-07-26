package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.dao.repo.CourseRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CourseDaoImpl implements CourseDao {

    private final CourseRepo courseRepo;

    @Override
    public CourseRepo getRepo() {
        return courseRepo;
    }


}
