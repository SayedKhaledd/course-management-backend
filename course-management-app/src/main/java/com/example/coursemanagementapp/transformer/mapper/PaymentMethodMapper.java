package com.example.coursemanagementapp.transformer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.InjectionStrategy;
import com.example.coursemanagementapp.dto.PaymentMethodDto;
import com.example.coursemanagementapp.model.PaymentMethod;
import com.example.backendcoreservice.transformer.mapper.AbstractMapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PaymentMethodMapper extends AbstractMapper<PaymentMethod, PaymentMethodDto> {


}
