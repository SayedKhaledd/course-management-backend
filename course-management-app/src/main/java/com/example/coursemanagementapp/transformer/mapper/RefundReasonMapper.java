package com.example.coursemanagementapp.transformer.mapper;

import com.example.backendcoreservice.transformer.mapper.AbstractMapper;
import com.example.coursemanagementapp.dto.RefundReasonDto;
import com.example.coursemanagementapp.model.RefundReason;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface RefundReasonMapper extends AbstractMapper<RefundReason, RefundReasonDto> {


}
