package com.example.coursemanagementapp.service;

import com.example.backendcoreservice.service.AbstractService;
import com.example.coursemanagementapp.dao.RefundReasonDao;
import com.example.coursemanagementapp.dto.RefundReasonDto;
import com.example.coursemanagementapp.model.RefundReason;
import com.example.coursemanagementapp.transformer.RefundReasonTransformer;

public interface RefundReasonService extends AbstractService<RefundReason, RefundReasonDto, RefundReasonTransformer, RefundReasonDao> {

}
