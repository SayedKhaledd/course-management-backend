package com.example.coursemanagementapp.dao;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import com.example.coursemanagementapp.dao.repo.ReferralSourceRepo;

@Component
@AllArgsConstructor
public class ReferralSourceDaoImpl implements ReferralSourceDao {

    private final ReferralSourceRepo referralsourceRepo;

    @Override
    public ReferralSourceRepo getRepo() {
        return referralsourceRepo;
    }


}
