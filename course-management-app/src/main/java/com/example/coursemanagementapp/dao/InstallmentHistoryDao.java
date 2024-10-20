package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.model.InstallmentHistory;
import com.example.backendcoreservice.dao.AbstractDao;
import com.example.coursemanagementapp.dao.repo.InstallmentHistoryRepo;

import java.util.List;

public interface InstallmentHistoryDao extends AbstractDao<InstallmentHistory, InstallmentHistoryRepo> {

    List<InstallmentHistory> findAllByInstallmentIdAndFieldName(Long installmentId, String fieldName);
}
