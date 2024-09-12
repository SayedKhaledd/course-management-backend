package com.example.coursemanagementapp.transformer.mapper;

import com.example.backendcoreservice.transformer.mapper.AbstractMapper;
import com.example.coursemanagementapp.dto.ReferralSourceDto;
import com.example.coursemanagementapp.model.ReferralSource;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ReferralSourceMapper extends AbstractMapper<ReferralSource, ReferralSourceDto> {


}
