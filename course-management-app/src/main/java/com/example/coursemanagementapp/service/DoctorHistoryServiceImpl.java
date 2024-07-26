package com.example.coursemanagementapp.service;

import com.example.coursemanagementapp.dao.DoctorHistoryDao;
import com.example.coursemanagementapp.transformer.DoctorHistoryTransformer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class DoctorHistoryServiceImpl implements DoctorHistoryService {

    private final DoctorHistoryDao doctorhistoryDao;
    private final DoctorHistoryTransformer doctorhistoryTransformer;

    @Override
    public DoctorHistoryDao getDao() {
        return doctorhistoryDao;
    }

    @Override
    public DoctorHistoryTransformer getTransformer() {
        return doctorhistoryTransformer;
    }


}
