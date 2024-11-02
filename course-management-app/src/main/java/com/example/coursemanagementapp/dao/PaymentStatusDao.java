package com.example.coursemanagementapp.dao;

import com.example.backendcoreservice.dao.AbstractDao;
import com.example.coursemanagementapp.dao.repo.PaymentStatusRepo;
import com.example.coursemanagementapp.model.PaymentStatus;

public interface PaymentStatusDao extends AbstractDao<PaymentStatus, PaymentStatusRepo> {

    PaymentStatus findEntityByName(com.example.coursemanagementapp.enums.PaymentStatus paymentStatus);
}
