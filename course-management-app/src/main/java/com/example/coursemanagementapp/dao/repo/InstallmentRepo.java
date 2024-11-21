package com.example.coursemanagementapp.dao.repo;

import com.example.coursemanagementapp.dto.search.InstallmentSearchDto;
import com.example.coursemanagementapp.model.Installment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InstallmentRepo extends JpaRepository<Installment, Long> {

    @Query("""
             SELECT i FROM Installment i
             WHERE
             (:#{#criteria.enrollmentId} IS NULL OR i.enrollment.id = :#{#criteria.enrollmentId})
             AND (:#{#criteria.clientName} IS NULL OR i.enrollment.client.name  LIKE CONCAT('%', (:#{#criteria.clientName}), '%'))
             AND (:#{#criteria.courseName} IS NULL OR i.enrollment.course.name  LIKE CONCAT('%', (:#{#criteria.courseName}), '%'))
             AND (:#{#criteria.paymentStatusIds} IS NULL OR i.paymentStatus.id IN :#{#criteria.paymentStatusIds})
             AND (:#{#criteria.paymentMethodIds} IS NULL OR i.paymentMethod.id IN :#{#criteria.paymentMethodIds})
             AND (:#{#criteria.amount} IS NULL OR i.amount = :#{#criteria.amount})
             AND (:#{#criteria.dueDate} IS NULL OR CAST(i.dueDate AS string)  LIKE CONCAT('%', (:#{#criteria.dueDate}), '%'))
             AND (:#{#criteria.paymentDate} IS NULL OR CAST(i.paymentDate AS string)   LIKE CONCAT('%', (:#{#criteria.paymentDate}), '%'))
             AND (:#{#criteria.createdBy} IS NULL OR i.createdBy = :#{#criteria.createdBy})
             AND (:#{#criteria.modifiedBy} IS NULL OR i.modifiedBy = :#{#criteria.modifiedBy})
             AND (:#{#criteria.createdDate} IS NULL OR CAST(i.createdDate AS string)  LIKE CONCAT('%', (:#{#criteria.createdDate}), '%'))
             AND (:#{#criteria.modifiedDate} IS NULL OR CAST(i.modifiedDate AS string)  LIKE CONCAT('%', (:#{#criteria.modifiedDate} ), '%'))
            """)
    Page<Installment> findAllFilteredAndPaginated(Pageable pageable, InstallmentSearchDto criteria);

}
