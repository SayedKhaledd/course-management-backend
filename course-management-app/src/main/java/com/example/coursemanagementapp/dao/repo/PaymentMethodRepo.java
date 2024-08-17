package com.example.coursemanagementapp.dao.repo;

import com.example.coursemanagementapp.model.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentMethodRepo extends JpaRepository<PaymentMethod, Long> {
    List<PaymentMethod> findAllByMarkedAsDeletedFalse();
}
