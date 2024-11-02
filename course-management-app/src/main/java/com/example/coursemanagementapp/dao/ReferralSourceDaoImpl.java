package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.dao.repo.ReferralSourceRepo;
import com.example.coursemanagementapp.model.ReferralSource;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

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
}
