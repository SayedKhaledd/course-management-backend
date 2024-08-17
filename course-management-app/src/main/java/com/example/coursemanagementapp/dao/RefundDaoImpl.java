package com.example.coursemanagementapp.dao;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import com.example.coursemanagementapp.dao.repo.RefundRepo;

@Component
@AllArgsConstructor
public class RefundDaoImpl implements RefundDao {

    private final RefundRepo refundRepo;

    @Override
    public RefundRepo getRepo() {
        return refundRepo;
    }


}
