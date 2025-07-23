package com.example.coursemanagementapp.dao.repo;

import com.example.coursemanagementapp.model.ReferralSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ReferralSourceRepo extends JpaRepository<ReferralSource, Long> {

    ReferralSource findEntityBySource(com.example.coursemanagementapp.enums.ReferralSource source);

    @Query(value="SELECT CASE WHEN COUNT(r) > 0 THEN TRUE ELSE FALSE END FROM referral_source r WHERE r.source = :name and r.marked_as_deleted=false", nativeQuery = true)
    Boolean existsByName(String name);

    @Query(value = "SELECT * FROM referral_source r WHERE r.source IN (:sources) and r.marked_as_deleted=false", nativeQuery = true)
    List<ReferralSource> findAllBySourceIn( Set<String> sources);
}
