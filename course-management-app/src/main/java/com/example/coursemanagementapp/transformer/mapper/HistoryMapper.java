package com.example.coursemanagementapp.transformer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.InjectionStrategy;
import com.example.coursemanagementapp.dto.HistoryDto;
import com.example.coursemanagementapp.model.History;
import com.example.backendcoreservice.transformer.mapper.AbstractMapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface HistoryMapper extends AbstractMapper<History, HistoryDto> {


}
