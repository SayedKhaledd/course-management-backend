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
    @Query(value = "UPDATE refund SET refunded_amount = :refundedAmount WHERE id = :id and marked_as_deleted=false ", nativeQuery = true)
    void updateRefundedAmount(Long id, Double refundedAmount);

    @Modifying
    @Query(value = "UPDATE refund SET refund_date = :refundDate WHERE id = :id and marked_as_deleted=false ", nativeQuery = true)
    void updateRefundDate(Long id, LocalDateTime refundDate);

    @Modifying
    @Query(value = "UPDATE refund SET first_explanation = :firstExplanation WHERE id = :id and marked_as_deleted=false ", nativeQuery = true)
    void updateFirstExplanation(Long id, String firstExplanation);

    @Modifying
    @Query(value = "UPDATE refund SET second_explanation = :secondExplanation WHERE id = :id and marked_as_deleted=false ", nativeQuery = true)
    void updateSecondExplanation(Long id, String secondExplanation);

    @Modifying
    @Query(value = "UPDATE refund SET refund_reason_id = :refundReasonId WHERE id = :id and marked_as_deleted=false ", nativeQuery = true)
    void updateRefundReason(Long id, Long refundReasonId);

    @Modifying
    @Query(value = "UPDATE refund SET refund_method_id = :refundMethodId WHERE id = :id and marked_as_deleted=false ", nativeQuery = true)
    void updateRefundMethod(Long id, Long refundMethodId);

    @Modifying
    @Query(value = "UPDATE refund SET refund_status_id = :refundStatusId WHERE id = :id and marked_as_deleted=false ", nativeQuery = true)
    void updateRefundStatus(Long id, Long refundStatusId);

    @Modifying
    @Query(value = "UPDATE refund SET is_received = :isReceived WHERE id = :id and marked_as_deleted=false ", nativeQuery = true)
    void updateIsReceived(Long id, Boolean isReceived);
}
