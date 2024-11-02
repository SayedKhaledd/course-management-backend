package com.example.coursemanagementapp.transformer;

import com.example.backendcoreservice.transformer.AbstractTransformer;
import com.example.coursemanagementapp.dto.ReferralSourceDto;
import com.example.coursemanagementapp.model.ReferralSource;
import com.example.coursemanagementapp.transformer.mapper.ReferralSourceMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ReferralSourceTransformer implements AbstractTransformer<ReferralSource, ReferralSourceDto, ReferralSourceMapper> {

    private final ReferralSourceMapper referralsourceMapper;

    @Override
    public ReferralSourceMapper getMapper() {
        return referralsourceMapper;
    }


}
