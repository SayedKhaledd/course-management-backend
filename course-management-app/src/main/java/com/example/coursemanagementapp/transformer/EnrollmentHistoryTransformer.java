package com.example.coursemanagementapp.transformer;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import com.example.coursemanagementapp.transformer.mapper.EnrollmentHistoryMapper;
import com.example.coursemanagementapp.dto.EnrollmentHistoryDto;
import com.example.coursemanagementapp.model.EnrollmentHistory;
import com.example.backendcoreservice.transformer.AbstractTransformer;

@Component
@AllArgsConstructor
public class EnrollmentHistoryTransformer implements AbstractTransformer<EnrollmentHistory, EnrollmentHistoryDto, EnrollmentHistoryMapper> {

    private final EnrollmentHistoryMapper enrollmenthistoryMapper;

    @Override
    public EnrollmentHistoryMapper getMapper() {
        return enrollmenthistoryMapper;
    }


}
