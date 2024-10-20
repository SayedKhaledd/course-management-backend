package com.example.coursemanagementapp.service;

import com.example.coursemanagementapp.model.RefundHistory;
import com.example.coursemanagementapp.dto.RefundHistoryDto;
import com.example.coursemanagementapp.transformer.RefundHistoryTransformer;
import com.example.coursemanagementapp.dao.RefundHistoryDao;
import com.example.backendcoreservice.service.AbstractService;

import java.util.List;

public interface RefundHistoryService extends AbstractService<RefundHistory, RefundHistoryDto, RefundHistoryTransformer, RefundHistoryDao> {

    List<RefundHistoryDto> findAllByRefundIdAndFieldName(Long refundId, String fieldName);

}
