package com.example.coursemanagementapp.service;

import com.example.coursemanagementapp.dao.EnrollmentHistoryDao;
import com.example.coursemanagementapp.dto.EnrollmentHistoryDto;
import com.example.coursemanagementapp.transformer.EnrollmentHistoryTransformer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class EnrollmentHistoryServiceImpl implements EnrollmentHistoryService {

    private final EnrollmentHistoryDao enrollmenthistoryDao;
    private final EnrollmentHistoryTransformer enrollmenthistoryTransformer;

    @Override
    public EnrollmentHistoryDao getDao() {
        return enrollmenthistoryDao;
    }

    @Override
    public EnrollmentHistoryTransformer getTransformer() {
        return enrollmenthistoryTransformer;
    }

    @Override
    public List<EnrollmentHistoryDto> findAllByEnrollmentIdAndFieldName(Long enrollmentId, String fieldName) {
        log.info("EnrollmentHistoryServiceImpl: findAllByEnrollmentIdAndFieldName() - was called");
        return getTransformer().transformEntitiesToDtos(getDao().findAllByEnrollmentIdAndFieldName(enrollmentId, fieldName));
    }
}
