package com.example.coursemanagementapp.service;

import com.example.coursemanagementapp.dao.SpecialityDao;
import com.example.coursemanagementapp.transformer.SpecialityTransformer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class SpecialityServiceImpl implements SpecialityService {

    private final SpecialityDao specialityDao;
    private final SpecialityTransformer specialityTransformer;

    @Override
    public SpecialityDao getDao() {
        return specialityDao;
    }

    @Override
    public SpecialityTransformer getTransformer() {
        return specialityTransformer;
    }


}
