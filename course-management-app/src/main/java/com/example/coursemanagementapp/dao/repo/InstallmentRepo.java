package com.example.coursemanagementapp.dao.repo;

import com.example.coursemanagementapp.model.Installment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstallmentRepo extends JpaRepository<Installment, Long> {

}
