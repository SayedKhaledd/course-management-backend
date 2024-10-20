package com.example.coursemanagementapp.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.coursemanagementapp.model.InstallmentHistory;

import java.util.List;

@Repository
public interface InstallmentHistoryRepo extends JpaRepository<InstallmentHistory, Long> {

    List<InstallmentHistory> findAllByInstallmentIdAndFieldName(Long installmentId, String fieldName);
}
