package com.example.coursemanagementapp.transformer.mapper;

import com.example.backendcoreservice.transformer.mapper.AbstractMapper;
import com.example.coursemanagementapp.dto.PaymentMethodDto;
import com.example.coursemanagementapp.model.PaymentMethod;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PaymentMethodMapper extends AbstractMapper<PaymentMethod, PaymentMethodDto> {


}
