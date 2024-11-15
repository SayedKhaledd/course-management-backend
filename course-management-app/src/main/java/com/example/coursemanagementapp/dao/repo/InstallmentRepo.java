package com.example.coursemanagementapp.dao.repo;

import com.example.coursemanagementapp.dto.search.InstallmentSearchDto;
import com.example.coursemanagementapp.model.Installment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

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


    @Modifying
    @Query(value = "UPDATE installment SET modified_date = :currentDate, modified_by = :modifiedBy WHERE id = :id AND marked_as_deleted = false", nativeQuery = true)
    void updateModifiedDateAndModifiedBy(Long id, String modifiedBy, LocalDateTime currentDate);

    @Modifying
    @Query(value = "UPDATE installment SET amount = :amount WHERE id = :id and marked_as_deleted=false ", nativeQuery = true)
    void updateAmount(Long id, Double amount);

    @Modifying
    @Query(value = "UPDATE installment SET payment_due_date = :dueDate WHERE id = :id and marked_as_deleted=false ", nativeQuery = true)
    void updateDueDate(Long id, LocalDateTime dueDate);

    @Modifying
    @Query(value = "UPDATE installment SET payment_date = :paymentDate WHERE id = :id and marked_as_deleted=false ", nativeQuery = true)
    void updatePaymentDate(Long id, LocalDateTime paymentDate);

    @Modifying
    @Query(value = "UPDATE installment SET payment_status_id = :paymentStatusId WHERE id = :id and marked_as_deleted=false ", nativeQuery = true)
    void updatePaymentStatus(Long id, Long paymentStatusId);

    @Modifying
    @Query(value = "UPDATE installment SET payment_method_id = :paymentMethodId WHERE id = :id and marked_as_deleted=false ", nativeQuery = true)
    void updatePaymentMethod(Long id, Long paymentMethodId);

    @Modifying
    @Query(value = "UPDATE installment SET is_received = :isReceived WHERE id = :id and marked_as_deleted=false ", nativeQuery = true)
    void updateIsReceived(Long id, Boolean isReceived);
}
