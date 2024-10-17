package com.example.coursemanagementapp.controller;

import com.example.backendcoreservice.api.ApiResponse;
import com.example.backendcoreservice.api.ApiResponseBuilder;
import com.example.backendcoreservice.controller.AbstractController;
import com.example.coursemanagementapp.dto.EnrollmentDto;
import com.example.coursemanagementapp.service.EnrollmentService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/enrollment")
@AllArgsConstructor
public class EnrollmentController implements AbstractController<EnrollmentService, EnrollmentDto> {

    private final EnrollmentService enrollmentService;
    private final ApiResponseBuilder<EnrollmentDto> apiResponseBuilder;


    @Override
    public EnrollmentService getService() {
        return enrollmentService;
    }

    @Override
    public ApiResponseBuilder<EnrollmentDto> getApiResponseBuilder() {
        return apiResponseBuilder;
    }

    @GetMapping("/all")
    public ApiResponse<List<EnrollmentDto>> findAll() {
        return getApiResponseBuilder().buildSuccessResponse(getService().findAll());
    }

    @GetMapping("/client/{id}")
    public ApiResponse<List<EnrollmentDto>> findAllByClientId(@PathVariable Long id) {
        return getApiResponseBuilder().buildSuccessResponse(getService().findAllByClientId(id));
    }


    @PostMapping
    public ApiResponse<EnrollmentDto> create(@Validated @RequestBody EnrollmentDto dto) {
        return getApiResponseBuilder().buildSuccessResponse(getService().create(dto));
    }


}
