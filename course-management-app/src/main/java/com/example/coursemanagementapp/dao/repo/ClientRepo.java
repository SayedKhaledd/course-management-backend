package com.example.coursemanagementapp.dao.repo;

import com.example.coursemanagementapp.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends JpaRepository<Client, Long> {

    @Query("""
            SELECT c
            FROM Client c
            WHERE
                (:name IS NULL OR c.name LIKE %:name%)
                AND (:email IS NULL OR c.email LIKE %:email%)
                AND (:phone IS NULL OR c.phone LIKE %:phone%)
            """)
    Page<Client> findAllFilteredAndPaginated(Pageable pageable, String name, String email, String phone);

}
