package com.example.coursemanagementapp.dao.repo;

import com.example.coursemanagementapp.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends JpaRepository<Client, Long> {

}
