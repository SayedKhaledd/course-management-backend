package com.example.coursemanagementapp.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.example.coursemanagementapp.dao.CourseStatusDao;
import com.example.coursemanagementapp.transformer.CourseStatusTransformer;

@Slf4j
@Service
@AllArgsConstructor
public class CourseStatusServiceImpl implements CourseStatusService {

    private final CourseStatusDao coursestatusDao;
    private final CourseStatusTransformer coursestatusTransformer;

    @Override
    public CourseStatusDao getDao() {
        return coursestatusDao;
    }

    @Override
    public CourseStatusTransformer getTransformer() {
        return coursestatusTransformer;
    }
    



}
