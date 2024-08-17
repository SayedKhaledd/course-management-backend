package com.example.coursemanagementapp.transformer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.InjectionStrategy;
import com.example.coursemanagementapp.dto.CourseStatusDto;
import com.example.coursemanagementapp.model.CourseStatus;
import com.example.backendcoreservice.transformer.mapper.AbstractMapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CourseStatusMapper extends AbstractMapper<CourseStatus, CourseStatusDto> {


}
