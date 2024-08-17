package com.example.coursemanagementapp.transformer;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import com.example.coursemanagementapp.transformer.mapper.EnrollmentMapper;
import com.example.coursemanagementapp.dto.EnrollmentDto;
import com.example.coursemanagementapp.model.Enrollment;
import com.example.backendcoreservice.transformer.AbstractTransformer;

@Component
@AllArgsConstructor
public class EnrollmentTransformer implements AbstractTransformer<Enrollment, EnrollmentDto, EnrollmentMapper> {

    private final EnrollmentMapper enrollmentMapper;

    @Override
    public EnrollmentMapper getMapper() {
        return enrollmentMapper;
    }


}
