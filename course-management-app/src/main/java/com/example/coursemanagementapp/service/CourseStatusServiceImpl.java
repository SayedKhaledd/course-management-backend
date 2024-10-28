package com.example.coursemanagementapp.service;

import com.example.coursemanagementapp.dao.CourseStatusDao;
import com.example.coursemanagementapp.model.CourseStatus;
import com.example.coursemanagementapp.transformer.CourseStatusTransformer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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

    @Override
    public String getEntityName() {
        return CourseStatus.class.getSimpleName();
    }

    @Override
    public CourseStatus findEntityByStatus(com.example.coursemanagementapp.enums.CourseStatus status) {
        log.info("CourseStatusService: findEntityByStatus() - was called");
        return getDao().findByStatus(status);
    }
}
