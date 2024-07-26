package com.example.coursemanagementapp.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.coursemanagementapp.dto.DoctorHistoryDto;
import com.example.coursemanagementapp.service.DoctorHistoryService;
import com.example.backendcoreservice.controller.AbstractController;
import com.example.backendcoreservice.api.ApiResponseBuilder;


@RestController
@RequestMapping("/api/doctorhistory")
@AllArgsConstructor
public class DoctorHistoryController implements AbstractController<DoctorHistoryService, DoctorHistoryDto> {

    private final DoctorHistoryService doctorhistoryService;
    private final ApiResponseBuilder<DoctorHistoryDto> apiResponseBuilder;


    @Override
    public DoctorHistoryService getService() {
        return doctorhistoryService;
    }

    @Override
    public ApiResponseBuilder<DoctorHistoryDto> getApiResponseBuilder() {
        return apiResponseBuilder;
    }


}
