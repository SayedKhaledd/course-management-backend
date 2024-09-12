package com.example.coursemanagementapp.transformer;

import com.example.backendcoreservice.transformer.AbstractTransformer;
import com.example.coursemanagementapp.dto.EnrollmentHistoryDto;
import com.example.coursemanagementapp.model.EnrollmentHistory;
import com.example.coursemanagementapp.transformer.mapper.EnrollmentHistoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EnrollmentHistoryTransformer implements AbstractTransformer<EnrollmentHistory, EnrollmentHistoryDto, EnrollmentHistoryMapper> {

    private final EnrollmentHistoryMapper enrollmenthistoryMapper;

    @Override
    public EnrollmentHistoryMapper getMapper() {
        return enrollmenthistoryMapper;
    }


}
