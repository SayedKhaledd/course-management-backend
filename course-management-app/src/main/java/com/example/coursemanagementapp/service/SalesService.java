package com.example.coursemanagementapp.service;

import com.example.coursemanagementapp.dto.SalesDto;

import java.util.List;

public interface SalesService {
    List<SalesDto> findAll();
}
