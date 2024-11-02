package com.example.coursemanagementapp.validator;

import com.example.coursemanagementapp.dto.ActionTakenDto;
import com.example.coursemanagementapp.dto.EnrollmentDto;

public interface EnrollmentValidator {

    Boolean shouldCreateRefund(EnrollmentDto enrollmentDto, ActionTakenDto actionTakenDto);

}
