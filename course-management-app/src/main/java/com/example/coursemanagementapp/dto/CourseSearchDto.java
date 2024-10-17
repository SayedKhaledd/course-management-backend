package com.example.coursemanagementapp.dto;

import lombok.Data;

import java.util.Set;

@Data
public class CourseSearchDto {
    private Set<Long> ids;
    private String name;
    private String code;
    private Set<Long> statusIds;
    private String part;
}
