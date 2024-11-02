package com.example.coursemanagementapp.dao.repo;

import com.example.coursemanagementapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    @Modifying
    @Query(value = """
            UPDATE "user" SET modified_date = :currentDate,
                              modified_by = :modifiedBy
                          WHERE id = :id AND marked_as_deleted = false
            """, nativeQuery = true)
    void updateModifiedDateAndModifiedBy(Long id, String modifiedBy, LocalDateTime currentDate);

    @Modifying
    @Query(value = """
            UPDATE "user" SET role = :role WHERE id = :id
            AND marked_as_deleted = false
            """, nativeQuery = true)
    void updateRole(Long id, String role);


    @Modifying
    @Query(value = """
            UPDATE "user" SET first_name = :firstName WHERE id = :id
            AND marked_as_deleted = false
            """, nativeQuery = true)
    void updateFirstName(Long id, String firstName);

    @Modifying
    @Query(value = """
            UPDATE "user" SET last_name = :lastName WHERE id = :id
            AND marked_as_deleted = false
            """, nativeQuery = true)
    void updateLastName(Long id, String lastName);

    @Modifying
    @Query(value = """
            UPDATE "user" SET email = :email WHERE id = :id
            AND marked_as_deleted = false
            """, nativeQuery = true)
    void updateEmail(Long id, String email);

    @Modifying
    @Query(value = """
            UPDATE "user" SET phone_number = :phoneNumber WHERE id = :id
            AND marked_as_deleted = false
            """, nativeQuery = true)
    void updatePhoneNumber(Long id, String phoneNumber);
}
