package com.example.coursemanagementapp.transformer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.InjectionStrategy;
import com.example.coursemanagementapp.dto.RefundHistoryDto;
import com.example.coursemanagementapp.model.RefundHistory;
import com.example.backendcoreservice.transformer.mapper.AbstractMapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface RefundHistoryMapper extends AbstractMapper<RefundHistory, RefundHistoryDto> {


}
