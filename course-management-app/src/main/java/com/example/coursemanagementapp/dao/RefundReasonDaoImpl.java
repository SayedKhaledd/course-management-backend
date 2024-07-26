package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.dao.repo.RefundReasonRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RefundReasonDaoImpl implements RefundReasonDao {

    private final RefundReasonRepo refundreasonRepo;

    @Override
    public RefundReasonRepo getRepo() {
        return refundreasonRepo;
    }


}
