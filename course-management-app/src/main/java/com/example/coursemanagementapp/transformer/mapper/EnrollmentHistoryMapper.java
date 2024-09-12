package com.example.coursemanagementapp.transformer.mapper;

import com.example.backendcoreservice.transformer.mapper.AbstractMapper;
import com.example.coursemanagementapp.dto.EnrollmentHistoryDto;
import com.example.coursemanagementapp.model.EnrollmentHistory;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface EnrollmentHistoryMapper extends AbstractMapper<EnrollmentHistory, EnrollmentHistoryDto> {


}
