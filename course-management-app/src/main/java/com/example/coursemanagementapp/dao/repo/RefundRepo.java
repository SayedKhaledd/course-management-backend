package com.example.coursemanagementapp.dao.repo;

import com.example.coursemanagementapp.model.Refund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface RefundRepo extends JpaRepository<Refund, Long> {
    @Modifying
    @Query(value = "UPDATE refund SET modified_date = :currentDate, modified_by = :modifiedBy WHERE id = :id AND marked_as_deleted = false", nativeQuery = true)
    void updateModifiedDateAndModifiedBy(Long id, String modifiedBy, LocalDateTime currentDate);

    @Modifying
    @Query(value = "UPDATE refund SET amount = :amount WHERE id = :id and marked_as_deleted=false ", nativeQuery = true)
    void updateAmount(Long id, Double amount);

    @Modifying
    @Query(value = "UPDATE refund SET refund_date = :refundDate WHERE id = :id and marked_as_deleted=false ", nativeQuery = true)
    void updateRefundDate(Long id, LocalDateTime refundDate);

    @Modifying
    @Query(value = "UPDATE refund SET is_confirmed = :isConfirmed WHERE id = :id and marked_as_deleted=false ", nativeQuery = true)
    void updateIsConfirmed(Long id, Boolean isConfirmed);

    @Modifying
    @Query(value = "UPDATE refund SET explanation = :explanation WHERE id = :id and marked_as_deleted=false ", nativeQuery = true)
    void updateExplanation(Long id, String explanation);

    @Modifying
    @Query(value = "UPDATE refund SET refund_reason_id = :refundReasonId WHERE id = :id and marked_as_deleted=false ", nativeQuery = true)
    void updateRefundReason(Long id, Long refundReasonId);

    @Modifying
    @Query(value = "UPDATE refund SET payment_method_id = :paymentMethodId WHERE id = :id and marked_as_deleted=false ", nativeQuery = true)
    void updatePaymentMethod(Long id, Long paymentMethodId);
}
