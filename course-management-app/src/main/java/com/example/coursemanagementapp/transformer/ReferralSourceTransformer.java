package com.example.coursemanagementapp.transformer;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import com.example.coursemanagementapp.transformer.mapper.ReferralSourceMapper;
import com.example.coursemanagementapp.dto.ReferralSourceDto;
import com.example.coursemanagementapp.model.ReferralSource;
import com.example.backendcoreservice.transformer.AbstractTransformer;

@Component
@AllArgsConstructor
public class ReferralSourceTransformer implements AbstractTransformer<ReferralSource, ReferralSourceDto, ReferralSourceMapper> {

    private final ReferralSourceMapper referralsourceMapper;

    @Override
    public ReferralSourceMapper getMapper() {
        return referralsourceMapper;
    }


}
