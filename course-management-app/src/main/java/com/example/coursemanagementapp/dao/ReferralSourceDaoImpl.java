package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.model.ReferralSource;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import com.example.coursemanagementapp.dao.repo.ReferralSourceRepo;

import java.util.List;

@Component
@AllArgsConstructor
public class ReferralSourceDaoImpl implements ReferralSourceDao {

    private final ReferralSourceRepo referralsourceRepo;

    @Override
    public ReferralSourceRepo getRepo() {
        return referralsourceRepo;
    }

    @Override
    public List<ReferralSource> findAll() {
        return getRepo().findAllByMarkedAsDeletedFalse();
    }
}
