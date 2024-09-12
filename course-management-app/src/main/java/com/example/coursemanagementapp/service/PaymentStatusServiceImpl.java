package com.example.coursemanagementapp.service;

import com.example.coursemanagementapp.dao.PaymentStatusDao;
import com.example.coursemanagementapp.transformer.PaymentStatusTransformer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class PaymentStatusServiceImpl implements PaymentStatusService {

    private final PaymentStatusDao paymentstatusDao;
    private final PaymentStatusTransformer paymentstatusTransformer;

    @Override
    public PaymentStatusDao getDao() {
        return paymentstatusDao;
    }

    @Override
    public PaymentStatusTransformer getTransformer() {
        return paymentstatusTransformer;
    }


}
