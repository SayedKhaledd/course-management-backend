package com.example.coursemanagementapp.controller;

import com.example.backendcoreservice.api.ApiResponseBuilder;
import com.example.backendcoreservice.controller.AbstractController;
import com.example.coursemanagementapp.dto.SpecialityDto;
import com.example.coursemanagementapp.service.SpecialityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/speciality")
@AllArgsConstructor
public class SpecialityController implements AbstractController<SpecialityService, SpecialityDto> {

    private final SpecialityService specialityService;
    private final ApiResponseBuilder<SpecialityDto> apiResponseBuilder;


    @Override
    public SpecialityService getService() {
        return specialityService;
    }

    @Override
    public ApiResponseBuilder<SpecialityDto> getApiResponseBuilder() {
        return apiResponseBuilder;
    }


}
