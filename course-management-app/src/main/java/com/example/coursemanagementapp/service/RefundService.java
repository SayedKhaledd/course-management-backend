package com.example.coursemanagementapp.service;

import com.example.coursemanagementapp.model.Refund;
import com.example.coursemanagementapp.dto.RefundDto;
import com.example.coursemanagementapp.transformer.RefundTransformer;
import com.example.coursemanagementapp.dao.RefundDao;
import com.example.backendcoreservice.service.AbstractService;

public interface RefundService extends AbstractService<Refund, RefundDto, RefundTransformer, RefundDao> {

}
