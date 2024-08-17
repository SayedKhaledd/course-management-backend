package com.example.coursemanagementapp.service;

import com.example.coursemanagementapp.model.PaymentMethod;
import com.example.coursemanagementapp.dto.PaymentMethodDto;
import com.example.coursemanagementapp.transformer.PaymentMethodTransformer;
import com.example.coursemanagementapp.dao.PaymentMethodDao;
import com.example.backendcoreservice.service.AbstractService;

public interface PaymentMethodService extends AbstractService<PaymentMethod, PaymentMethodDto, PaymentMethodTransformer, PaymentMethodDao> {

}
