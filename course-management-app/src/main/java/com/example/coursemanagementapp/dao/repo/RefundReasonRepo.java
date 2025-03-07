package com.example.coursemanagementapp.dao.repo;

import com.example.coursemanagementapp.model.RefundReason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefundReasonRepo extends JpaRepository<RefundReason, Long> {

}
