package com.example.coursemanagementapp.service;

import com.example.backendcoreservice.service.AbstractService;
import com.example.coursemanagementapp.dao.RefundDao;
import com.example.coursemanagementapp.dto.RefundDto;
import com.example.coursemanagementapp.model.Refund;
import com.example.coursemanagementapp.transformer.RefundTransformer;

public interface RefundService extends AbstractService<Refund, RefundDto, RefundTransformer, RefundDao> {

}
