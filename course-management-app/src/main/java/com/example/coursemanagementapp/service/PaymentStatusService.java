package com.example.coursemanagementapp.service;

import com.example.coursemanagementapp.model.PaymentStatus;
import com.example.coursemanagementapp.dto.PaymentStatusDto;
import com.example.coursemanagementapp.transformer.PaymentStatusTransformer;
import com.example.coursemanagementapp.dao.PaymentStatusDao;
import com.example.backendcoreservice.service.AbstractService;

public interface PaymentStatusService extends AbstractService<PaymentStatus, PaymentStatusDto, PaymentStatusTransformer, PaymentStatusDao> {

}
