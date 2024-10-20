package com.example.coursemanagementapp.service;

import com.example.coursemanagementapp.model.InstallmentHistory;
import com.example.coursemanagementapp.dto.InstallmentHistoryDto;
import com.example.coursemanagementapp.transformer.InstallmentHistoryTransformer;
import com.example.coursemanagementapp.dao.InstallmentHistoryDao;
import com.example.backendcoreservice.service.AbstractService;

import java.util.List;

public interface InstallmentHistoryService extends AbstractService<InstallmentHistory, InstallmentHistoryDto, InstallmentHistoryTransformer, InstallmentHistoryDao> {

    List<InstallmentHistoryDto> findAllByInstallmentIdAndFieldName(Long installmentId, String fieldName);
}
