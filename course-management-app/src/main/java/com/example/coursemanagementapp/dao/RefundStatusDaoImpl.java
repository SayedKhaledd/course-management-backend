package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.model.RefundStatus;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import com.example.coursemanagementapp.dao.repo.RefundStatusRepo;

@Component
@AllArgsConstructor
public class RefundStatusDaoImpl implements RefundStatusDao {

    private final RefundStatusRepo refundstatusRepo;

    @Override
    public RefundStatusRepo getRepo() {
        return refundstatusRepo;
    }

    @Override
    public RefundStatus findEntityByStatus(com.example.coursemanagementapp.enums.RefundStatus refundStatus) {
      return  getRepo().findByStatus(refundStatus);
    }
}
