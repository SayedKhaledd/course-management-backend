package com.example.coursemanagementapp.dao.repo;

import com.example.coursemanagementapp.model.ClientStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ClientStatusRepo extends JpaRepository<ClientStatus, Long> {

    ClientStatus findEntityByStatus(com.example.coursemanagementapp.enums.ClientStatus status);

    @Query(value ="SELECT * FROM client_status c WHERE c.status IN (:statuses) and c.marked_as_deleted=false", nativeQuery = true)
    List<ClientStatus> findAllByStatusesIn(Set<String> statuses);

    @Query(value = "SELECT CASE WHEN COUNT(c) > 0 THEN TRUE ELSE FALSE END FROM client_status c WHERE c.status = :status and c.marked_as_deleted=false", nativeQuery = true)
    Boolean existsByStatus(String status);
}
