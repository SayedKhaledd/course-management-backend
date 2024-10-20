package com.example.coursemanagementapp.transformer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.InjectionStrategy;
import com.example.coursemanagementapp.dto.CourseLecturerHistoryDto;
import com.example.coursemanagementapp.model.CourseLecturerHistory;
import com.example.backendcoreservice.transformer.mapper.AbstractMapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CourseLecturerHistoryMapper extends AbstractMapper<CourseLecturerHistory, CourseLecturerHistoryDto> {


}
