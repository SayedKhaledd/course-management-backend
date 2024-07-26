package com.example.coursemanagementapp.transformer.mapper;

import com.example.backendcoreservice.transformer.mapper.AbstractMapper;
import com.example.coursemanagementapp.dto.DoctorHistoryDto;
import com.example.coursemanagementapp.model.DoctorHistory;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface DoctorHistoryMapper extends AbstractMapper<DoctorHistory, DoctorHistoryDto> {


}
