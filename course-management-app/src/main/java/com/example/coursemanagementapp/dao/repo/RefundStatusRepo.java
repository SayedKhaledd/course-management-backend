package com.example.coursemanagementapp.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.coursemanagementapp.model.RefundStatus;

@Repository
public interface RefundStatusRepo extends JpaRepository<RefundStatus, Long> {

    RefundStatus findByStatus(com.example.coursemanagementapp.enums.RefundStatus refundStatus);

}
