package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.dao.repo.RefundHistoryRepo;
import com.example.coursemanagementapp.model.RefundHistory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class RefundHistoryDaoImpl implements RefundHistoryDao {

    private final RefundHistoryRepo refundhistoryRepo;

    @Override
    public RefundHistoryRepo getRepo() {
        return refundhistoryRepo;
    }

    @Override
    public List<RefundHistory> findAllByRefundIdAndFieldName(Long refundId, String fieldName) {
        return getRepo().findAllByRefundIdAndFieldName(refundId, fieldName);
    }

}
