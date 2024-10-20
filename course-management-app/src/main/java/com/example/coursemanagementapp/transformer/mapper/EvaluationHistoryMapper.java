package com.example.coursemanagementapp.transformer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.InjectionStrategy;
import com.example.coursemanagementapp.dto.EvaluationHistoryDto;
import com.example.coursemanagementapp.model.EvaluationHistory;
import com.example.backendcoreservice.transformer.mapper.AbstractMapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface EvaluationHistoryMapper extends AbstractMapper<EvaluationHistory, EvaluationHistoryDto> {


}
