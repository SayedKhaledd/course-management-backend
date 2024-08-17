package com.example.coursemanagementapp.transformer;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import com.example.coursemanagementapp.transformer.mapper.PaymentMethodMapper;
import com.example.coursemanagementapp.dto.PaymentMethodDto;
import com.example.coursemanagementapp.model.PaymentMethod;
import com.example.backendcoreservice.transformer.AbstractTransformer;

@Component
@AllArgsConstructor
public class PaymentMethodTransformer implements AbstractTransformer<PaymentMethod, PaymentMethodDto, PaymentMethodMapper> {

    private final PaymentMethodMapper paymentmethodMapper;

    @Override
    public PaymentMethodMapper getMapper() {
        return paymentmethodMapper;
    }


}
