package com.example.coursemanagementapp.service;

import com.example.backendcoreservice.service.AbstractService;
import com.example.coursemanagementapp.dao.ReferralSourceDao;
import com.example.coursemanagementapp.dto.ReferralSourceDto;
import com.example.coursemanagementapp.model.ReferralSource;
import com.example.coursemanagementapp.transformer.ReferralSourceTransformer;

import java.util.List;
import java.util.Set;

public interface ReferralSourceService extends AbstractService<ReferralSource, ReferralSourceDto, ReferralSourceTransformer, ReferralSourceDao> {

    ReferralSource findEntityByName(com.example.coursemanagementapp.enums.ReferralSource referralSource);

    List<ReferralSourceDto> findAllBySourcesIn(Set<String> sources);

    Boolean existsByName(String name);

}
