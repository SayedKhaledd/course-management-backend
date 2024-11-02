package com.example.coursemanagementapp.service;

import com.example.backendcoreservice.service.AbstractService;
import com.example.coursemanagementapp.dao.RefundStatusDao;
import com.example.coursemanagementapp.dto.RefundStatusDto;
import com.example.coursemanagementapp.model.RefundStatus;
import com.example.coursemanagementapp.transformer.RefundStatusTransformer;

public interface RefundStatusService extends AbstractService<RefundStatus, RefundStatusDto, RefundStatusTransformer, RefundStatusDao> {
    RefundStatus findEntityByStatus(com.example.coursemanagementapp.enums.RefundStatus refundStatus);
}
