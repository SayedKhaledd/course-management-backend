package com.example.coursemanagementapp.dao.repo;

import com.example.coursemanagementapp.model.RefundHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RefundHistoryRepo extends JpaRepository<RefundHistory, Long> {

    List<RefundHistory> findAllByRefundIdAndFieldName(Long refundId, String fieldName);
}
