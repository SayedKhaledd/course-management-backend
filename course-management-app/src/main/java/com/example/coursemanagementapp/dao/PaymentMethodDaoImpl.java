package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.dao.repo.PaymentMethodRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PaymentMethodDaoImpl implements PaymentMethodDao {

    private final PaymentMethodRepo paymentmethodRepo;

    @Override
    public PaymentMethodRepo getRepo() {
        return paymentmethodRepo;
    }

}
