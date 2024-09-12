package com.example.coursemanagementapp.transformer.mapper;

import com.example.backendcoreservice.transformer.mapper.AbstractMapper;
import com.example.coursemanagementapp.dto.ClientHistoryDto;
import com.example.coursemanagementapp.model.ClientHistory;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ClientHistoryMapper extends AbstractMapper<ClientHistory, ClientHistoryDto> {


}
