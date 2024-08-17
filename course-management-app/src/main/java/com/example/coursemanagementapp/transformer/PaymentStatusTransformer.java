package com.example.coursemanagementapp.transformer;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import com.example.coursemanagementapp.transformer.mapper.PaymentStatusMapper;
import com.example.coursemanagementapp.dto.PaymentStatusDto;
import com.example.coursemanagementapp.model.PaymentStatus;
import com.example.backendcoreservice.transformer.AbstractTransformer;

@Component
@AllArgsConstructor
public class PaymentStatusTransformer implements AbstractTransformer<PaymentStatus, PaymentStatusDto, PaymentStatusMapper> {

    private final PaymentStatusMapper paymentstatusMapper;

    @Override
    public PaymentStatusMapper getMapper() {
        return paymentstatusMapper;
    }


}
