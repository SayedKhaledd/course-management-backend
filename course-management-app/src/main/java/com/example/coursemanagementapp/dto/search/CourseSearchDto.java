package com.example.coursemanagementapp.dto.search;

import lombok.Data;

import java.util.Set;

@Data
public class CourseSearchDto {
    private String name;
    private String description;
    private String code;
    private String part;
    private Double price;
    private Set<Long> courseStatusIds;
    private Boolean isInitial = false;
    private String startDate;
    private String endDate;
    private String createdBy;
    private String modifiedBy;
    private String createdDate;
    private String modifiedDate;

    public Set<Long> getCourseStatusIds() {
        if (courseStatusIds == null || courseStatusIds.isEmpty())
            return null;
        return courseStatusIds;
    }
}
