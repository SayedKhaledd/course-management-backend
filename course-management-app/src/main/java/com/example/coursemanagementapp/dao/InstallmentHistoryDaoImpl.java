package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.model.InstallmentHistory;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import com.example.coursemanagementapp.dao.repo.InstallmentHistoryRepo;

import java.util.List;

@Component
@AllArgsConstructor
public class InstallmentHistoryDaoImpl implements InstallmentHistoryDao {

    private final InstallmentHistoryRepo installmenthistoryRepo;

    @Override
    public InstallmentHistoryRepo getRepo() {
        return installmenthistoryRepo;
    }

    @Override
    public List<InstallmentHistory> findAllByInstallmentIdAndFieldName(Long installmentId, String fieldName) {
        return getRepo().findAllByInstallmentIdAndFieldName(installmentId, fieldName);
    }

}
