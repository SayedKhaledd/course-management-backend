package com.example.coursemanagementapp.service;

import com.example.coursemanagementapp.dao.PaymentMethodDao;
import com.example.coursemanagementapp.transformer.PaymentMethodTransformer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class PaymentMethodServiceImpl implements PaymentMethodService {

    private final PaymentMethodDao paymentmethodDao;
    private final PaymentMethodTransformer paymentmethodTransformer;

    @Override
    public PaymentMethodDao getDao() {
        return paymentmethodDao;
    }

    @Override
    public PaymentMethodTransformer getTransformer() {
        return paymentmethodTransformer;
    }


}
