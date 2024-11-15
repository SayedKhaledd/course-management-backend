package com.example.coursemanagementapp.dao.repo;

import com.example.coursemanagementapp.dto.search.EnrollmentSearchDto;
import com.example.coursemanagementapp.model.Enrollment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EnrollmentRepo extends JpaRepository<Enrollment, Long> {

    List<Enrollment> findAllByClientId(Long clientId);

    List<Enrollment> findAllByCourseId(Long courseId);

    Enrollment findByClientIdAndCourseId(Long clientId, Long courseId);

    @Query("""
                SELECT e
                FROM Enrollment e
                WHERE
                    (:#{#enrollmentSearchDto.clientId} IS NULL OR e.client.id = :#{#enrollmentSearchDto.clientId})
                    AND (:#{#enrollmentSearchDto.courseId} IS NULL OR e.course.id = :#{#enrollmentSearchDto.courseId})
                    AND (:#{#enrollmentSearchDto.clientName} IS NULL OR e.client.name LIKE CONCAT('%', :#{#enrollmentSearchDto.clientName}, '%'))
                    AND (:#{#enrollmentSearchDto.courseName} IS NULL OR e.course.name LIKE CONCAT('%', :#{#enrollmentSearchDto.courseName}, '%'))
                    AND (:#{#enrollmentSearchDto.amountPaid} IS NULL OR e.amountPaid = :#{#enrollmentSearchDto.amountPaid})
                    AND (:#{#enrollmentSearchDto.remainingAmount} IS NULL OR e.remainingAmount = :#{#enrollmentSearchDto.remainingAmount})
                    AND (:#{#enrollmentSearchDto.totalAmount} IS NULL OR e.totalAmount = :#{#enrollmentSearchDto.totalAmount})
                    AND (:#{#enrollmentSearchDto.discount} IS NULL OR e.discount = :#{#enrollmentSearchDto.discount})
                    AND (:#{#enrollmentSearchDto.currencies} IS NULL OR e.currency IN :#{#enrollmentSearchDto.currencies})
                    AND (:#{#enrollmentSearchDto.payInInstallments} IS NULL OR e.payInInstallments IN :#{#enrollmentSearchDto.payInInstallments})
                    AND (:#{#enrollmentSearchDto.insideEgypt} IS NULL OR e.insideEgypt IN :#{#enrollmentSearchDto.insideEgypt})
                    AND (:#{#enrollmentSearchDto.review} IS NULL OR e.review LIKE CONCAT('%', :#{#enrollmentSearchDto.review}, '%'))
                    AND (:#{#enrollmentSearchDto.ratings} IS NULL OR e.rating IN :#{#enrollmentSearchDto.ratings})
                    AND (:#{#enrollmentSearchDto.description} IS NULL OR e.description LIKE CONCAT('%', :#{#enrollmentSearchDto.description}, '%'))
                    AND (:#{#enrollmentSearchDto.paymentStatusIds} IS NULL OR e.paymentStatusId IN :#{#enrollmentSearchDto.paymentStatusIds})
                    AND (:#{#enrollmentSearchDto.paymentMethodIds} IS NULL OR e.paymentMethodId IN :#{#enrollmentSearchDto.paymentMethodIds})
                    AND (:#{#enrollmentSearchDto.actionTakenIds} IS NULL OR e.actionTakenId IN :#{#enrollmentSearchDto.actionTakenIds})
                    AND (:#{#enrollmentSearchDto.referralSourceIds} IS NULL OR e.referralSourceId IN :#{#enrollmentSearchDto.referralSourceIds})
                    AND (:#{#enrollmentSearchDto.createdBy} IS NULL OR e.createdBy LIKE CONCAT('%', :#{#enrollmentSearchDto.createdBy}, '%'))
                    AND (:#{#enrollmentSearchDto.modifiedBy} IS NULL OR e.modifiedBy LIKE CONCAT('%', :#{#enrollmentSearchDto.modifiedBy}, '%'))
                    AND (:#{#enrollmentSearchDto.createdDate} IS NULL OR CAST(e.createdDate AS string) LIKE CONCAT('%', :#{#enrollmentSearchDto.createdDate}, '%'))
                    AND (:#{#enrollmentSearchDto.modifiedDate} IS NULL OR CAST(e.modifiedDate AS string) LIKE CONCAT('%', :#{#enrollmentSearchDto.modifiedDate}, '%'))     
            """)
    Page<Enrollment> findAllFilteredAndPaginated(Pageable pageable, EnrollmentSearchDto enrollmentSearchDto);

    @Modifying
    @Query(value = "UPDATE enrollment SET modified_date = :currentDate, modified_by = :modifiedBy WHERE id = :id AND marked_as_deleted = false", nativeQuery = true)
    void updateModifiedDateAndModifiedBy(Long id, String modifiedBy, LocalDateTime currentDate);

    @Modifying
    @Query(value = "UPDATE enrollment SET amount_paid = :amountPaid WHERE id = :id and marked_as_deleted=false ", nativeQuery = true)
    void updateAmountPaid(Long id, Double amountPaid);

    @Modifying
    @Query(value = "UPDATE enrollment SET remaining_amount = :remainingAmount WHERE id = :id and marked_as_deleted=false ", nativeQuery = true)
    void updateRemainingAmount(Long id, Double remainingAmount);

    @Modifying
    @Query(value = "UPDATE enrollment SET discount = :discount WHERE id = :id and marked_as_deleted=false ", nativeQuery = true)
    void updateDiscount(Long id, Double discount);

    @Modifying
    @Query(value = "UPDATE enrollment SET currency = :currency WHERE id = :id and marked_as_deleted=false ", nativeQuery = true)
    void updateCurrency(Long id, String currency);

    @Modifying
    @Query(value = "UPDATE enrollment SET pay_in_installment = :payInInstallments WHERE id = :id and marked_as_deleted=false ", nativeQuery = true)
    void updatePayInInstallments(Long id, Boolean payInInstallments);

    @Modifying
    @Query(value = "UPDATE enrollment SET inside_egypt = :insideEgypt WHERE id = :id and marked_as_deleted=false ", nativeQuery = true)
    void updateInsideEgypt(Long id, Boolean insideEgypt);

    @Modifying
    @Query(value = "UPDATE enrollment SET review = :review WHERE id = :id and marked_as_deleted=false ", nativeQuery = true)
    void updateReview(Long id, String review);

    @Modifying
    @Query(value = "UPDATE enrollment SET rate = :rating WHERE id = :id and marked_as_deleted=false ", nativeQuery = true)
    void updateRating(Long id, String rating);


    @Modifying
    @Query(value = "UPDATE enrollment SET description = :description WHERE id = :id and marked_as_deleted=false ", nativeQuery = true)
    void updateDescription(Long id, String description);


    @Modifying
    @Query(value = "UPDATE enrollment SET payment_status_id = :paymentStatusId WHERE id = :id and marked_as_deleted=false ", nativeQuery = true)
    void updatePaymentStatus(Long id, Long paymentStatusId);

    @Modifying
    @Query(value = "UPDATE enrollment SET payment_method_id = :paymentMethodId WHERE id = :id and marked_as_deleted=false ", nativeQuery = true)
    void updatePaymentMethod(Long id, Long paymentMethodId);

    @Modifying
    @Query(value = "UPDATE enrollment SET action_taken_id = :actionTakenId WHERE id = :id and marked_as_deleted=false ", nativeQuery = true)
    void updateActionTaken(Long id, Long actionTakenId);

    @Modifying
    @Query(value = "UPDATE enrollment SET referral_source_id = :referralSourceId WHERE id = :id and marked_as_deleted=false ", nativeQuery = true)
    void updateReferralSource(Long id, Long referralSourceId);


    @Modifying
    @Query(value = "UPDATE enrollment SET client_id = :clientId, referral_source_id = (SELECT referral_source_id FROM client WHERE id = :clientId) WHERE id = :id and marked_as_deleted=false", nativeQuery = true)
    void updateClient(Long id, Long clientId);

    @Modifying
    @Query(value = "UPDATE enrollment SET course_id = :courseId, remaining_amount = (SELECT price FROM course WHERE id = :courseId), amount_paid = 0, discount = 0 WHERE id = :id and marked_as_deleted=false ", nativeQuery = true)
    void updateCourse(Long id, Long courseId);

    @Modifying
    @Query(value = "UPDATE enrollment SET is_received = :isReceived WHERE id = :id and marked_as_deleted=false ", nativeQuery = true)
    void updateIsReceived(Long id, Boolean isReceived);


    @Modifying
    @Query(value = "UPDATE enrollment SET total_amount = :totalAmount WHERE id = :id and marked_as_deleted=false ", nativeQuery = true)
    void updateTotalAmount(Long id, Double totalAmount);
}
