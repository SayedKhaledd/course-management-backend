package com.example.coursemanagementapp.transformer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.InjectionStrategy;
import com.example.coursemanagementapp.dto.CourseHistoryDto;
import com.example.coursemanagementapp.model.CourseHistory;
import com.example.backendcoreservice.transformer.mapper.AbstractMapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CourseHistoryMapper extends AbstractMapper<CourseHistory, CourseHistoryDto> {


}
