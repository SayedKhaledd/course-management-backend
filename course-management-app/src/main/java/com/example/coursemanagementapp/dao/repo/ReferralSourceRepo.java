package com.example.coursemanagementapp.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.coursemanagementapp.model.ReferralSource;

import java.util.List;

@Repository
public interface ReferralSourceRepo extends JpaRepository<ReferralSource, Long> {

    List<ReferralSource> findAllByMarkedAsDeletedFalse();
}
