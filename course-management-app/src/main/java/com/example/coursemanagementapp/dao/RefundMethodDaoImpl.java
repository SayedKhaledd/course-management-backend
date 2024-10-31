package com.example.coursemanagementapp.dao;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import com.example.coursemanagementapp.dao.repo.RefundMethodRepo;

@Component
@AllArgsConstructor
public class RefundMethodDaoImpl implements RefundMethodDao {

    private final RefundMethodRepo refundmethodRepo;

    @Override
    public RefundMethodRepo getRepo() {
        return refundmethodRepo;
    }


}
