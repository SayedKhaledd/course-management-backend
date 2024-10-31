package com.example.coursemanagementapp.transformer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.InjectionStrategy;
import com.example.coursemanagementapp.dto.RefundMethodDto;
import com.example.coursemanagementapp.model.RefundMethod;
import com.example.backendcoreservice.transformer.mapper.AbstractMapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface RefundMethodMapper extends AbstractMapper<RefundMethod, RefundMethodDto> {


}
