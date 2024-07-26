package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.dao.repo.RefundRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RefundDaoImpl implements RefundDao {

    private final RefundRepo refundRepo;

    @Override
    public RefundRepo getRepo() {
        return refundRepo;
    }


}
