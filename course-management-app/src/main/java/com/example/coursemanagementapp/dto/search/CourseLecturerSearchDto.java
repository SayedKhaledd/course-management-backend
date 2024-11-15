package com.example.coursemanagementapp.dto.search;

import lombok.Data;

import java.util.Set;

@Data
public class CourseLecturerSearchDto {
    private Long courseId;
    private String name;
    private Set<Boolean> paidInPercentage;
    private Double percentage;
    private Double totalPercentageCost;
    private Long noOfLectures;
    private Double lectureCost;
    private Double totalFixedCost;
    private String createdBy;
    private String modifiedBy;
    private String createdDate;
    private String modifiedDate;

    public Set<Boolean> getPaidInPercentage() {
        if (paidInPercentage == null || paidInPercentage.isEmpty())
            return null;
        return paidInPercentage;
    }
}
