package com.example.coursemanagementapp.dao.repo;

import com.example.coursemanagementapp.dto.search.RefundSearchDto;
import com.example.coursemanagementapp.model.Refund;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface RefundRepo extends JpaRepository<Refund, Long> {

    @Query("""
             SELECT r  FROM Refund r
             WHERE
             (:#{#criteria.enrollmentId} IS NULL OR r.enrollment.id = :#{#criteria.enrollmentId})
             AND (:#{#criteria.clientName} IS NULL OR r.enrollment.client.name  LIKE CONCAT('%', (:#{#criteria.clientName}), '%'))
             AND (:#{#criteria.courseName} IS NULL OR r.enrollment.course.name  LIKE CONCAT('%', (:#{#criteria.courseName}), '%'))
             AND (:#{#criteria.refundedAmount} IS NULL OR r.refundedAmount = :#{#criteria.refundedAmount})
             AND (:#{#criteria.refundDate} IS NULL OR CAST(r.refundDate AS string)  LIKE CONCAT('%', (:#{#criteria.refundDate}), '%'))
             AND (:#{#criteria.firstExplanation} IS NULL OR r.firstExplanation  LIKE CONCAT('%', (:#{#criteria.firstExplanation}), '%'))
             AND (:#{#criteria.secondExplanation} IS NULL OR r.secondExplanation  LIKE CONCAT('%', (:#{#criteria.secondExplanation}), '%'))
             AND (:#{#criteria.refundReasonIds} IS NULL OR r.refundReason.id IN :#{#criteria.refundReasonIds})
             AND (:#{#criteria.refundMethodIds} IS NULL OR r.refundMethod.id IN :#{#criteria.refundMethodIds})
             AND (:#{#criteria.refundStatusIds} IS NULL OR r.refundStatus.id IN :#{#criteria.refundStatusIds})
             AND (:#{#criteria.paymentMethodIds} IS NULL OR r.paymentMethod.id IN :#{#criteria.paymentMethodIds})
            AND (:#{#criteria.enrollmentAmount} IS NULL OR r.enrollmentAmount = :#{#criteria.enrollmentAmount})
            AND (:#{#criteria.createdBy} IS NULL OR r.createdBy = :#{#criteria.createdBy})
            AND (:#{#criteria.modifiedBy} IS NULL OR r.modifiedBy = :#{#criteria.modifiedBy})
            AND (:#{#criteria.createdDate} IS NULL OR CAST(r.createdDate AS string)  LIKE CONCAT('%', (:#{#criteria.createdDate}), '%'))
            AND (:#{#criteria.modifiedDate} IS NULL OR CAST(r.modifiedDate AS string)  LIKE CONCAT('%', (:#{#criteria.modifiedDate} ), '%'))
            """)
    Page<Refund> findAllFilteredAndPaginated(Pageable pageable, RefundSearchDto criteria);


}
