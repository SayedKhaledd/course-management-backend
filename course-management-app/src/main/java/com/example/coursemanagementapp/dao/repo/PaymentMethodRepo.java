package com.example.coursemanagementapp.dao.repo;

import com.example.coursemanagementapp.model.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodRepo extends JpaRepository<PaymentMethod, Long> {

}
