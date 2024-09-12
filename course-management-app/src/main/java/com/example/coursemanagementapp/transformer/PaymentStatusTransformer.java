package com.example.coursemanagementapp.transformer;

import com.example.backendcoreservice.transformer.AbstractTransformer;
import com.example.coursemanagementapp.dto.PaymentStatusDto;
import com.example.coursemanagementapp.model.PaymentStatus;
import com.example.coursemanagementapp.transformer.mapper.PaymentStatusMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PaymentStatusTransformer implements AbstractTransformer<PaymentStatus, PaymentStatusDto, PaymentStatusMapper> {

    private final PaymentStatusMapper paymentstatusMapper;

    @Override
    public PaymentStatusMapper getMapper() {
        return paymentstatusMapper;
    }


}
