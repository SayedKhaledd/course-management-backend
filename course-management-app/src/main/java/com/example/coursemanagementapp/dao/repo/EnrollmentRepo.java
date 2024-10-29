package com.example.coursemanagementapp.dao.repo;

import com.example.coursemanagementapp.model.Enrollment;
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
    void updateRating(Long id, Integer rating);


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
}
