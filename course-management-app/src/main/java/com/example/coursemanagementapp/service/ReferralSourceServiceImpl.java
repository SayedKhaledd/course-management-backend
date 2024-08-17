package com.example.coursemanagementapp.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.example.coursemanagementapp.dao.ReferralSourceDao;
import com.example.coursemanagementapp.transformer.ReferralSourceTransformer;

@Slf4j
@Service
@AllArgsConstructor
public class ReferralSourceServiceImpl implements ReferralSourceService {

    private final ReferralSourceDao referralsourceDao;
    private final ReferralSourceTransformer referralsourceTransformer;

    @Override
    public ReferralSourceDao getDao() {
        return referralsourceDao;
    }

    @Override
    public ReferralSourceTransformer getTransformer() {
        return referralsourceTransformer;
    }
    



}
