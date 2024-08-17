package com.example.coursemanagementapp.dao;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import com.example.coursemanagementapp.dao.repo.CourseRepo;

@Component
@AllArgsConstructor
public class CourseDaoImpl implements CourseDao {

    private final CourseRepo courseRepo;

    @Override
    public CourseRepo getRepo() {
        return courseRepo;
    }


}
