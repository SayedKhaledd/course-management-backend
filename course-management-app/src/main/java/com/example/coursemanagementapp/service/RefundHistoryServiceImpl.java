package com.example.coursemanagementapp.service;

import com.example.coursemanagementapp.dao.RefundHistoryDao;
import com.example.coursemanagementapp.dto.RefundHistoryDto;
import com.example.coursemanagementapp.transformer.RefundHistoryTransformer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class RefundHistoryServiceImpl implements RefundHistoryService {

    private final RefundHistoryDao refundhistoryDao;
    private final RefundHistoryTransformer refundhistoryTransformer;

    @Override
    public RefundHistoryDao getDao() {
        return refundhistoryDao;
    }

    @Override
    public RefundHistoryTransformer getTransformer() {
        return refundhistoryTransformer;
    }

    @Override
    public List<RefundHistoryDto> findAllByRefundIdAndFieldName(Long refundId, String fieldName) {
        log.info("RefundHistoryServiceImpl: findAllByRefundIdAndFieldName() - was called");
        return getTransformer().transformEntitiesToDtos(getDao().findAllByRefundIdAndFieldName(refundId, fieldName));
    }
}
