package com.example.coursemanagementapp.service;

import com.example.coursemanagementapp.dao.RefundStatusDao;
import com.example.coursemanagementapp.model.RefundStatus;
import com.example.coursemanagementapp.transformer.RefundStatusTransformer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@AllArgsConstructor
public class RefundStatusServiceImpl implements RefundStatusService {

    private final RefundStatusDao refundstatusDao;
    private final RefundStatusTransformer refundstatusTransformer;

    @Override
    public RefundStatusDao getDao() {
        return refundstatusDao;
    }

    @Override
    public RefundStatusTransformer getTransformer() {
        return refundstatusTransformer;
    }

    @Override
    public String getEntityName() {
        return RefundStatus.class.getSimpleName();
    }

    @Override
    public RefundStatus findEntityByStatus(com.example.coursemanagementapp.enums.RefundStatus refundStatus) {
        log.info("RefundStatusService: findEntityByStatus() - was called");
        return getDao().findEntityByStatus(refundStatus);
    }


}
