package com.example.coursemanagementapp.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.example.coursemanagementapp.dao.CourseLecturerDao;
import com.example.coursemanagementapp.transformer.CourseLecturerTransformer;

@Slf4j
@Service
@AllArgsConstructor
public class CourseLecturerServiceImpl implements CourseLecturerService {

    private final CourseLecturerDao courselecturerDao;
    private final CourseLecturerTransformer courselecturerTransformer;

    @Override
    public CourseLecturerDao getDao() {
        return courselecturerDao;
    }

    @Override
    public CourseLecturerTransformer getTransformer() {
        return courselecturerTransformer;
    }
    



}