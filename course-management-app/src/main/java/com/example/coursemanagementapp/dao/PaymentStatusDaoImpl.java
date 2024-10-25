package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.dao.repo.PaymentStatusRepo;
import com.example.coursemanagementapp.model.PaymentStatus;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PaymentStatusDaoImpl implements PaymentStatusDao {

    private final PaymentStatusRepo paymentstatusRepo;

    @Override
    public PaymentStatusRepo getRepo() {
        return paymentstatusRepo;
    }

    @Override
    public PaymentStatus findEntityByName(com.example.coursemanagementapp.enums.PaymentStatus paymentStatus) {
        return getRepo().findByStatus(paymentStatus);
    }
}
