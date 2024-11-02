package com.example.coursemanagementapp.validator;

import com.example.coursemanagementapp.dto.ActionTakenDto;
import com.example.coursemanagementapp.dto.EnrollmentDto;
import com.example.coursemanagementapp.enums.ActionTaken;
import com.example.coursemanagementapp.enums.PaymentStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EnrollmentValidatorImpl implements EnrollmentValidator {

    @Override
    public Boolean shouldCreateRefund(EnrollmentDto enrollmentDto, ActionTakenDto actionTakenDto) {
        log.info("EnrollmentValidator: shouldCreateRefund() - called");
        return actionTakenDto.getAction().equals(ActionTaken.REFUND) && enrollmentDto.getPaymentStatus().getStatus().equals(PaymentStatus.DONE) &&
                enrollmentDto.getAmountPaid() > 0;
    }

}
