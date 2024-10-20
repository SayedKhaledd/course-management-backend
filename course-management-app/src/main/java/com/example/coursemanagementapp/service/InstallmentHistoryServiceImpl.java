package com.example.coursemanagementapp.service;

import com.example.coursemanagementapp.dto.InstallmentHistoryDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.example.coursemanagementapp.dao.InstallmentHistoryDao;
import com.example.coursemanagementapp.transformer.InstallmentHistoryTransformer;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class InstallmentHistoryServiceImpl implements InstallmentHistoryService {

    private final InstallmentHistoryDao installmenthistoryDao;
    private final InstallmentHistoryTransformer installmenthistoryTransformer;

    @Override
    public InstallmentHistoryDao getDao() {
        return installmenthistoryDao;
    }

    @Override
    public InstallmentHistoryTransformer getTransformer() {
        return installmenthistoryTransformer;
    }


    @Override
    public List<InstallmentHistoryDto> findAllByInstallmentIdAndFieldName(Long installmentId, String fieldName) {
        log.info("InstallmentHistoryServiceImpl: findAllByInstallmentIdAndFieldName() - was called");
        return getTransformer().transformEntitiesToDtos(getDao().findAllByInstallmentIdAndFieldName(installmentId, fieldName));
    }
}
