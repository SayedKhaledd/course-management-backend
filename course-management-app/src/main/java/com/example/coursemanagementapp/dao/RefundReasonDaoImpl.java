package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.model.RefundReason;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import com.example.coursemanagementapp.dao.repo.RefundReasonRepo;

import java.util.List;

@Component
@AllArgsConstructor
public class RefundReasonDaoImpl implements RefundReasonDao {

    private final RefundReasonRepo refundreasonRepo;

    @Override
    public RefundReasonRepo getRepo() {
        return refundreasonRepo;
    }

    @Override
    public List<RefundReason> findAll() {
        return getRepo().findAllByMarkedAsDeletedFalse();
    }
}
