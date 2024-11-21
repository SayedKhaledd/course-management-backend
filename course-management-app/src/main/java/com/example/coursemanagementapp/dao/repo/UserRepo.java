package com.example.coursemanagementapp.dao.repo;

import com.example.coursemanagementapp.dto.search.UserSearchDto;
import com.example.coursemanagementapp.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    @Query("""
                        SELECT u FROM User u
                        WHERE (:#{#criteria.firstName} IS NULL OR u.firstName = :#{#criteria.firstName})
                        AND (:#{#criteria.lastName} IS NULL OR u.lastName = :#{#criteria.lastName})
                        AND (:#{#criteria.email} IS NULL OR u.email = :#{#criteria.email})
                        AND (:#{#criteria.phoneNumber} IS NULL OR u.phoneNumber = :#{#criteria.phoneNumber})
                        AND (:#{#criteria.roles} IS NULL OR u.role IN :#{#criteria.roles})
            AND (:#{#criteria.createdBy} IS NULL OR u.createdBy = :#{#criteria.createdBy})
            AND (:#{#criteria.modifiedBy} IS NULL OR u.modifiedBy = :#{#criteria.modifiedBy})
            AND (:#{#criteria.createdDate} IS NULL OR CAST(u.createdDate AS string)  LIKE CONCAT('%', (:#{#criteria.createdDate}), '%'))
            AND (:#{#criteria.modifiedDate} IS NULL OR CAST(u.modifiedDate AS string)  LIKE CONCAT('%', (:#{#criteria.modifiedDate} ), '%'))
            """)
    Page<User> findAllFilteredAndPaginated(Pageable pageable, UserSearchDto criteria);

}
