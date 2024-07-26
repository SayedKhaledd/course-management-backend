package com.example.coursemanagementapp.dao.repo;

import com.example.coursemanagementapp.model.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialityRepo extends JpaRepository<Speciality, Long> {

}
