package com.example.coursemanagementapp.service;

import com.example.coursemanagementapp.dao.CourseHistoryDao;
import com.example.coursemanagementapp.dto.CourseHistoryDto;
import com.example.coursemanagementapp.transformer.CourseHistoryTransformer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class CourseHistoryServiceImpl implements CourseHistoryService {

    private final CourseHistoryDao coursehistoryDao;
    private final CourseHistoryTransformer coursehistoryTransformer;

    @Override
    public CourseHistoryDao getDao() {
        return coursehistoryDao;
    }

    @Override
    public CourseHistoryTransformer getTransformer() {
        return coursehistoryTransformer;
    }


    @Override
    public List<CourseHistoryDto> findAllByCourseIdAndFieldName(Long courseId, String fieldName) {
        return getTransformer().transformEntitiesToDtos(getDao().findAllByCourseIdAndFieldName(courseId, fieldName));
    }


}
