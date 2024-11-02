package com.example.coursemanagementapp.transformer.mapper;

import com.example.backendcoreservice.transformer.mapper.AbstractMapper;
import com.example.coursemanagementapp.dto.PaymentStatusDto;
import com.example.coursemanagementapp.model.PaymentStatus;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PaymentStatusMapper extends AbstractMapper<PaymentStatus, PaymentStatusDto> {


}
