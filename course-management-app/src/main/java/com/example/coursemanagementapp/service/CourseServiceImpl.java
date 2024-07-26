package com.example.coursemanagementapp.service;

import com.example.coursemanagementapp.dao.CourseDao;
import com.example.coursemanagementapp.transformer.CourseTransformer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseDao courseDao;
    private final CourseTransformer courseTransformer;

    @Override
    public CourseDao getDao() {
        return courseDao;
    }

    @Override
    public CourseTransformer getTransformer() {
        return courseTransformer;
    }


}
