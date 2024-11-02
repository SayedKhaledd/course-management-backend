package com.example.coursemanagementapp.transformer.mapper;

import com.example.backendcoreservice.transformer.mapper.AbstractMapper;
import com.example.coursemanagementapp.dto.ClientStatusDto;
import com.example.coursemanagementapp.model.ClientStatus;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ClientStatusMapper extends AbstractMapper<ClientStatus, ClientStatusDto> {


}
