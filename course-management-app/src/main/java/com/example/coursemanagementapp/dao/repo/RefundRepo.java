package com.example.coursemanagementapp.dao.repo;

import com.example.coursemanagementapp.model.Refund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefundRepo extends JpaRepository<Refund, Long> {

}
