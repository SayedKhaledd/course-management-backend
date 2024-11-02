package com.example.coursemanagementapp.transformer.mapper;

import com.example.backendcoreservice.transformer.mapper.AbstractMapper;
import com.example.coursemanagementapp.dto.EnrollmentDto;
import com.example.coursemanagementapp.model.Enrollment;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {ClientMapper.class, CourseMapper.class, PaymentMethodMapper.class, PaymentStatusMapper.class,
                ReferralSourceMapper.class, ActionTakenMapper.class})
public interface EnrollmentMapper extends AbstractMapper<Enrollment, EnrollmentDto> {


}
