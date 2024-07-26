package com.example.coursemanagementapp.transformer;

import com.example.backendcoreservice.transformer.AbstractTransformer;
import com.example.coursemanagementapp.dto.PaymentMethodDto;
import com.example.coursemanagementapp.model.PaymentMethod;
import com.example.coursemanagementapp.transformer.mapper.PaymentMethodMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PaymentMethodTransformer implements AbstractTransformer<PaymentMethod, PaymentMethodDto, PaymentMethodMapper> {

    private final PaymentMethodMapper paymentmethodMapper;

    @Override
    public PaymentMethodMapper getMapper() {
        return paymentmethodMapper;
    }


}
