package com.example.coursemanagementapp.dao.repo;

import com.example.coursemanagementapp.model.ClientStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientStatusRepo extends JpaRepository<ClientStatus, Long> {

}
