package com.example.coursemanagementapp.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.coursemanagementapp.model.PaymentStatus;

import java.util.List;

@Repository
public interface PaymentStatusRepo extends JpaRepository<PaymentStatus, Long> {

    List<PaymentStatus> findAllByMarkedAsDeletedFalse();
}
