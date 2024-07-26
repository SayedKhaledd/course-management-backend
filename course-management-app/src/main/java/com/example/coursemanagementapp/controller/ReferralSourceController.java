package com.example.coursemanagementapp.controller;

import com.example.backendcoreservice.api.ApiResponseBuilder;
import com.example.backendcoreservice.controller.AbstractController;
import com.example.coursemanagementapp.dto.ReferralSourceDto;
import com.example.coursemanagementapp.service.ReferralSourceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/referralsource")
@AllArgsConstructor
public class ReferralSourceController implements AbstractController<ReferralSourceService, ReferralSourceDto> {

    private final ReferralSourceService referralsourceService;
    private final ApiResponseBuilder<ReferralSourceDto> apiResponseBuilder;


    @Override
    public ReferralSourceService getService() {
        return referralsourceService;
    }

    @Override
    public ApiResponseBuilder<ReferralSourceDto> getApiResponseBuilder() {
        return apiResponseBuilder;
    }


}
