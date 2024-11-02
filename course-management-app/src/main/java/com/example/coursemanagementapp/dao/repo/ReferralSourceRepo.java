package com.example.coursemanagementapp.dao.repo;

import com.example.coursemanagementapp.model.ReferralSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReferralSourceRepo extends JpaRepository<ReferralSource, Long> {

    ReferralSource findEntityBySource(com.example.coursemanagementapp.enums.ReferralSource source);
}
