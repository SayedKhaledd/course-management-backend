package com.example.coursemanagementapp.transformer.mapper;

import com.example.coursemanagementapp.dto.ClientDto;
import com.example.coursemanagementapp.dto.ParsedClient;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {ClientMapper.class})
public interface ClientCsvMapper {


    @Mapping(target = "initialCourse", ignore = true)
    @Mapping(target = "referralSource", ignore = true)
    @Mapping(target = "clientStatus", ignore = true)
    @Mapping(target = "email", expression = "java(sanitize(client.getEmail()))")
    @Mapping(target = "alternativePhone", expression = "java(sanitize(client.getAlternativePhone()))")
    @Mapping(target = "country", expression = "java(sanitize(client.getCountry()))")
    @Mapping(target = "nationality", expression = "java(sanitize(client.getNationality()))")
    @Mapping(target = "address", expression = "java(sanitize(client.getAddress()))")
    @Mapping(target = "specialty", expression = "java(sanitize(client.getSpecialty()))")
    @Mapping(target = "description", expression = "java(sanitize(client.getDescription()))")
    ClientDto toClientDto(ParsedClient client);

    default String sanitize(String value) {
        return (value == null || value.isEmpty()) ? null : value;
    }
}
