package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.dao.repo.ReferralSourceRepo;
import com.example.coursemanagementapp.model.ReferralSource;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@AllArgsConstructor
public class ReferralSourceDaoImpl implements ReferralSourceDao {

    private final ReferralSourceRepo referralsourceRepo;

    @Override
    public ReferralSourceRepo getRepo() {
        return referralsourceRepo;
    }

    @Override
    public ReferralSource findEntityByName(com.example.coursemanagementapp.enums.ReferralSource referralSource) {
        return getRepo().findEntityBySource(referralSource);
    }

    @Override
    public List<ReferralSource> findAllBySourcesIn(Set<String> sources) {
        log.info("ReferralSourceDao: findAllBySourcesIn() - was called");
        return getRepo().findAllBySourceIn(sources);
    }

    @Override
    public Boolean existsByName(String name) {
        return getRepo().existsByName(name);
    }
}
