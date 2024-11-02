package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.dto.SalesDto;

import java.util.List;

public interface SalesDao {

    List<SalesDto> findAll();
}
