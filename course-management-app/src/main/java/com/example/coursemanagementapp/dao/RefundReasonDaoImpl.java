package com.example.coursemanagementapp.dao;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import com.example.coursemanagementapp.dao.repo.RefundReasonRepo;

@Component
@AllArgsConstructor
public class RefundReasonDaoImpl implements RefundReasonDao {

    private final RefundReasonRepo refundreasonRepo;

    @Override
    public RefundReasonRepo getRepo() {
        return refundreasonRepo;
    }


}
