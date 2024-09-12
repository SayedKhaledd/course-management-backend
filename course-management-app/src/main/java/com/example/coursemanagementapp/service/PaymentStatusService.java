package com.example.coursemanagementapp.service;

import com.example.backendcoreservice.service.AbstractService;
import com.example.coursemanagementapp.dao.PaymentStatusDao;
import com.example.coursemanagementapp.dto.PaymentStatusDto;
import com.example.coursemanagementapp.model.PaymentStatus;
import com.example.coursemanagementapp.transformer.PaymentStatusTransformer;

public interface PaymentStatusService extends AbstractService<PaymentStatus, PaymentStatusDto, PaymentStatusTransformer, PaymentStatusDao> {

}
