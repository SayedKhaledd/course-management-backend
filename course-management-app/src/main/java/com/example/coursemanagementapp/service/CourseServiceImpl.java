package com.example.coursemanagementapp.service;

import com.example.backendcoreservice.exception.CustomException;
import com.example.coursemanagementapp.dao.CourseDao;
import com.example.coursemanagementapp.transformer.CourseTransformer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    @Override
    public void updateStatus(Long id, Long statusId) {
        log.info("CourseService: updateStatus() - was called with id: {} and statusId: {}", id, statusId);
        if (!existsById(id))
            throw new CustomException("Course with id " + id + " does not exist");

        getDao().updateCourseStatus(id, statusId);
    }
}
