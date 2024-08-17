package com.example.coursemanagementapp.transformer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.InjectionStrategy;
import com.example.coursemanagementapp.dto.ActionTakenDto;
import com.example.coursemanagementapp.model.ActionTaken;
import com.example.backendcoreservice.transformer.mapper.AbstractMapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ActionTakenMapper extends AbstractMapper<ActionTaken, ActionTakenDto> {


}
