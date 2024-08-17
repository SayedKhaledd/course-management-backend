package com.example.coursemanagementapp.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.coursemanagementapp.model.ReferralSource;

@Repository
public interface ReferralSourceRepo extends JpaRepository<ReferralSource, Long> {

}
