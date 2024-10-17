package com.example.coursemanagementapp.transformer.mapper;

import com.example.backendcoreservice.transformer.mapper.AbstractMapper;
import com.example.coursemanagementapp.dto.ClientHistoryDto;
import com.example.coursemanagementapp.model.ClientHistory;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {ClientMapper.class})
public interface ClientHistoryMapper extends AbstractMapper<ClientHistory, ClientHistoryDto> {

    @Override
    @Mapping(target = "client", ignore = true)
    ClientHistoryDto transformEntityToDto(ClientHistory entity);
}
