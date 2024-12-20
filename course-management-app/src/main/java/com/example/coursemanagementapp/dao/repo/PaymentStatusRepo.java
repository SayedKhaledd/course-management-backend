package com.example.coursemanagementapp.dao.repo;

import com.example.coursemanagementapp.model.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentStatusRepo extends JpaRepository<PaymentStatus, Long> {

    PaymentStatus findByStatus(com.example.coursemanagementapp.enums.PaymentStatus paymentStatus);

}
