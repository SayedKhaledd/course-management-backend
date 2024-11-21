package com.example.coursemanagementapp.dto.search;

import lombok.Data;

import java.util.Set;

@Data
public class EvaluationSearchDto {
    private Long enrollmentId;
    private Long clientId;
    private String clientName;
    private String courseName;
    private String courseCode;
    private Set<Long> evaluationStatusIds;
    private String examName;
    private String createdBy;
    private String modifiedBy;
    private String createdDate;
    private String modifiedDate;

    public Set<Long> getEvaluationStatusIds() {
        if (evaluationStatusIds == null || evaluationStatusIds.isEmpty())
            return null;
        return evaluationStatusIds;
    }
}
