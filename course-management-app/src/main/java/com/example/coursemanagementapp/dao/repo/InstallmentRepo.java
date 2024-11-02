package com.example.coursemanagementapp.dao.repo;

import com.example.coursemanagementapp.model.Installment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface InstallmentRepo extends JpaRepository<Installment, Long> {
    @Modifying
    @Query(value = "UPDATE installment SET modified_date = :currentDate, modified_by = :modifiedBy WHERE id = :id AND marked_as_deleted = false", nativeQuery = true)
    void updateModifiedDateAndModifiedBy(Long id, String modifiedBy, LocalDateTime currentDate);

    @Modifying
    @Query(value = "UPDATE installment SET amount = :amount WHERE id = :id and marked_as_deleted=false ", nativeQuery = true)
    void updateAmount(Long id, Double amount);

    @Modifying
    @Query(value = "UPDATE installment SET due_date = :dueDate WHERE id = :id and marked_as_deleted=false ", nativeQuery = true)
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
