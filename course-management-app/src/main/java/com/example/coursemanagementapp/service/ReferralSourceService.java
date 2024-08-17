package com.example.coursemanagementapp.service;

import com.example.coursemanagementapp.model.ReferralSource;
import com.example.coursemanagementapp.dto.ReferralSourceDto;
import com.example.coursemanagementapp.transformer.ReferralSourceTransformer;
import com.example.coursemanagementapp.dao.ReferralSourceDao;
import com.example.backendcoreservice.service.AbstractService;

public interface ReferralSourceService extends AbstractService<ReferralSource, ReferralSourceDto, ReferralSourceTransformer, ReferralSourceDao> {

}
