package com.example.coursemanagementapp.controller;

import com.example.backendcoreservice.api.ApiResponse;
import com.example.backendcoreservice.api.ApiResponseBuilder;
import com.example.coursemanagementapp.dto.SalesDto;
import com.example.coursemanagementapp.service.SalesService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/sales")
@AllArgsConstructor
public class SalesController {
    private final SalesService salesService;
    private final ApiResponseBuilder apiResponseBuilder;

    public SalesService getService() {
        return salesService;
    }

    public ApiResponseBuilder getApiResponseBuilder() {
        return apiResponseBuilder;
    }

    @PreAuthorize("hasAuthority('SUPER_ADMIN') OR hasAuthority( 'ADMIN')")
    @GetMapping("/all")
    public ApiResponse<List<SalesDto>> findAll() {
        return getApiResponseBuilder().buildSuccessResponse(getService().findAll());
    }

    @GetMapping("/test")
    public String testEndpoint(Authentication authentication) {
        // Log the Authentication object
        log.info("Authentication: {}", authentication);

        // Log authorities (roles)
        log.info("Authorities: {}", authentication.getAuthorities());

        return "JWT Token processed successfully!";
    }

}
