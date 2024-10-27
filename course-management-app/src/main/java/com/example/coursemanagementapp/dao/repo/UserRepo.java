package com.example.coursemanagementapp.dao.repo;

import com.example.coursemanagementapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    @Modifying
    @Query(value = """
            UPDATE "user" SET role = :role WHERE id = :id
            AND marked_as_deleted = false
            """, nativeQuery = true)
    void updateUserByRole(Long id, String role);
}
