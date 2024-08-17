package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.model.CourseStatus;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import com.example.coursemanagementapp.dao.repo.CourseStatusRepo;

import java.util.List;

@Component
@AllArgsConstructor
public class CourseStatusDaoImpl implements CourseStatusDao {

    private final CourseStatusRepo coursestatusRepo;

    @Override
    public CourseStatusRepo getRepo() {
        return coursestatusRepo;
    }


    @Override
    public List<CourseStatus> findAll() {
        return getRepo().findAllByMarkedAsDeletedFalse();
    }
}
