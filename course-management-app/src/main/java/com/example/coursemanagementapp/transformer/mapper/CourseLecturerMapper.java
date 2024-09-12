package com.example.coursemanagementapp.transformer.mapper;

import com.example.backendcoreservice.transformer.mapper.AbstractMapper;
import com.example.coursemanagementapp.dto.CourseLecturerDto;
import com.example.coursemanagementapp.model.CourseLecturer;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CourseLecturerMapper extends AbstractMapper<CourseLecturer, CourseLecturerDto> {


}
