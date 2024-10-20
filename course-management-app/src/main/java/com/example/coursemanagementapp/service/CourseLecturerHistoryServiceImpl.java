package com.example.coursemanagementapp.service;

import com.example.coursemanagementapp.dao.CourseLecturerHistoryDao;
import com.example.coursemanagementapp.dto.CourseLecturerHistoryDto;
import com.example.coursemanagementapp.transformer.CourseLecturerHistoryTransformer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class CourseLecturerHistoryServiceImpl implements CourseLecturerHistoryService {

    private final CourseLecturerHistoryDao courselecturerhistoryDao;
    private final CourseLecturerHistoryTransformer courselecturerhistoryTransformer;

    @Override
    public CourseLecturerHistoryDao getDao() {
        return courselecturerhistoryDao;
    }

    @Override
    public CourseLecturerHistoryTransformer getTransformer() {
        return courselecturerhistoryTransformer;
    }


    @Override
    public List<CourseLecturerHistoryDto> findAllByCourseLecturerIdAndFieldName(Long courseLecturerId, String fieldName) {
        log.info("CourseLecturerHistoryServiceImpl: findAllByCourseLecturerIdAndFieldName() called");
        return getTransformer().transformEntitiesToDtos(getDao().findAllByCourseLecturerIdAndFieldName(courseLecturerId, fieldName));
    }
}
