package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.model.PaymentMethod;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import com.example.coursemanagementapp.dao.repo.PaymentMethodRepo;

import java.util.List;

@Component
@AllArgsConstructor
public class PaymentMethodDaoImpl implements PaymentMethodDao {

    private final PaymentMethodRepo paymentmethodRepo;

    @Override
    public PaymentMethodRepo getRepo() {
        return paymentmethodRepo;
    }

    @Override
    public List<PaymentMethod> findAll() {
        return getRepo().findAllByMarkedAsDeletedFalse();
    }
}
