package com.example.coursemanagementapp.dao;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import com.example.coursemanagementapp.dao.repo.PaymentMethodRepo;

@Component
@AllArgsConstructor
public class PaymentMethodDaoImpl implements PaymentMethodDao {

    private final PaymentMethodRepo paymentmethodRepo;

    @Override
    public PaymentMethodRepo getRepo() {
        return paymentmethodRepo;
    }


}
