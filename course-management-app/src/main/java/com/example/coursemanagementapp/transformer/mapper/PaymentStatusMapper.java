package com.example.coursemanagementapp.transformer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.InjectionStrategy;
import com.example.coursemanagementapp.dto.PaymentStatusDto;
import com.example.coursemanagementapp.model.PaymentStatus;
import com.example.backendcoreservice.transformer.mapper.AbstractMapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PaymentStatusMapper extends AbstractMapper<PaymentStatus, PaymentStatusDto> {


}
