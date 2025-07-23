package com.example.coursemanagementapp.dao;

import com.example.backendcoreservice.dao.AbstractDao;
import com.example.coursemanagementapp.dao.repo.ReferralSourceRepo;
import com.example.coursemanagementapp.model.ReferralSource;

import java.util.List;
import java.util.Set;

public interface ReferralSourceDao extends AbstractDao<ReferralSource, ReferralSourceRepo> {

    ReferralSource findEntityByName(com.example.coursemanagementapp.enums.ReferralSource referralSource);

    List<ReferralSource> findAllBySourcesIn(Set<String> sources);

    Boolean existsByName(String name);
}
