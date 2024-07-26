package com.example.coursemanagementapp.dao.repo;

import com.example.coursemanagementapp.model.DoctorHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorHistoryRepo extends JpaRepository<DoctorHistory, Long> {

}
