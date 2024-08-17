package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.model.PaymentStatus;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import com.example.coursemanagementapp.dao.repo.PaymentStatusRepo;

import java.util.List;

@Component
@AllArgsConstructor
public class PaymentStatusDaoImpl implements PaymentStatusDao {

    private final PaymentStatusRepo paymentstatusRepo;

    @Override
    public PaymentStatusRepo getRepo() {
        return paymentstatusRepo;
    }


    @Override
    public List<PaymentStatus> findAll() {
        return getRepo().findAllByMarkedAsDeletedFalse();
    }
}
