package com.example.coursemanagementapp.transformer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.InjectionStrategy;
import com.example.coursemanagementapp.dto.ReferralSourceDto;
import com.example.coursemanagementapp.model.ReferralSource;
import com.example.backendcoreservice.transformer.mapper.AbstractMapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ReferralSourceMapper extends AbstractMapper<ReferralSource, ReferralSourceDto> {


}
