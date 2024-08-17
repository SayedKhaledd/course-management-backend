package com.example.coursemanagementapp.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.coursemanagementapp.model.Installment;

@Repository
public interface InstallmentRepo extends JpaRepository<Installment, Long> {

}
