package com.example.coursemanagementapp.transformer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.InjectionStrategy;
import com.example.coursemanagementapp.dto.InstallmentHistoryDto;
import com.example.coursemanagementapp.model.InstallmentHistory;
import com.example.backendcoreservice.transformer.mapper.AbstractMapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface InstallmentHistoryMapper extends AbstractMapper<InstallmentHistory, InstallmentHistoryDto> {


}
