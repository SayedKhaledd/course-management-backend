package com.example.coursemanagementapp.transformer.mapper;

import com.example.backendcoreservice.transformer.mapper.AbstractMapper;
import com.example.coursemanagementapp.dto.ActionTakenDto;
import com.example.coursemanagementapp.model.ActionTaken;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ActionTakenMapper extends AbstractMapper<ActionTaken, ActionTakenDto> {


}
