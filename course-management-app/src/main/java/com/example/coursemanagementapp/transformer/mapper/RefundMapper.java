package com.example.coursemanagementapp.transformer.mapper;

import com.example.backendcoreservice.transformer.mapper.AbstractMapper;
import com.example.coursemanagementapp.dto.RefundDto;
import com.example.coursemanagementapp.model.Refund;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {EnrollmentMapper.class, PaymentMethodMapper.class, RefundReasonMapper.class,
                RefundStatusMapper.class, RefundMethodMapper.class})
public interface RefundMapper extends AbstractMapper<Refund, RefundDto> {


}
