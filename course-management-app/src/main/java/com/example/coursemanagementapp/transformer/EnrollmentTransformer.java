package com.example.coursemanagementapp.transformer;

import com.example.backendcoreservice.transformer.AbstractTransformer;
import com.example.coursemanagementapp.dto.EnrollmentDto;
import com.example.coursemanagementapp.model.Enrollment;
import com.example.coursemanagementapp.transformer.mapper.EnrollmentMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EnrollmentTransformer implements AbstractTransformer<Enrollment, EnrollmentDto, EnrollmentMapper> {

    private final EnrollmentMapper enrollmentMapper;

    @Override
    public EnrollmentMapper getMapper() {
        return enrollmentMapper;
    }


}
