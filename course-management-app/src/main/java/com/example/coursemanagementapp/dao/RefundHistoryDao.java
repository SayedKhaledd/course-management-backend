package com.example.coursemanagementapp.dao;

import com.example.backendcoreservice.dao.AbstractDao;
import com.example.coursemanagementapp.dao.repo.RefundHistoryRepo;
import com.example.coursemanagementapp.model.RefundHistory;

import java.util.List;

public interface RefundHistoryDao extends AbstractDao<RefundHistory, RefundHistoryRepo> {

    List<RefundHistory> findAllByRefundIdAndFieldName(Long refundId, String fieldName);
}
