package com.example.coursemanagementapp.service;

import com.example.coursemanagementapp.model.RefundMethod;
import com.example.coursemanagementapp.dto.RefundMethodDto;
import com.example.coursemanagementapp.transformer.RefundMethodTransformer;
import com.example.coursemanagementapp.dao.RefundMethodDao;
import com.example.backendcoreservice.service.AbstractService;

public interface RefundMethodService extends AbstractService<RefundMethod, RefundMethodDto, RefundMethodTransformer, RefundMethodDao> {

}
