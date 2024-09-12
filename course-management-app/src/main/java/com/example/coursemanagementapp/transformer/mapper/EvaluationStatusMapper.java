package com.example.coursemanagementapp.transformer.mapper;

import com.example.backendcoreservice.transformer.mapper.AbstractMapper;
import com.example.coursemanagementapp.dto.EvaluationStatusDto;
import com.example.coursemanagementapp.model.EvaluationStatus;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface EvaluationStatusMapper extends AbstractMapper<EvaluationStatus, EvaluationStatusDto> {


}
