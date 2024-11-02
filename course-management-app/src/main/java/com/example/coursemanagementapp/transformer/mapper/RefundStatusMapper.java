package com.example.coursemanagementapp.transformer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.InjectionStrategy;
import com.example.coursemanagementapp.dto.RefundStatusDto;
import com.example.coursemanagementapp.model.RefundStatus;
import com.example.backendcoreservice.transformer.mapper.AbstractMapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface RefundStatusMapper extends AbstractMapper<RefundStatus, RefundStatusDto> {


}
