package com.example.coursemanagementapp.dao;

import com.example.backendcoreservice.dao.AbstractDao;
import com.example.coursemanagementapp.dao.repo.EnrollmentRepo;
import com.example.coursemanagementapp.model.Enrollment;

import java.util.List;

public interface EnrollmentDao extends AbstractDao<Enrollment, EnrollmentRepo> {

    List<Enrollment> findAllByClientId(Long clientId);

    List<Enrollment> findAllByCourseId(Long courseId);

    Enrollment findByClientIdAndCourseId(Long clientId, Long courseId);

    void updateAmountPaid(Long id, Double amountPaid);

    void updateRemainingAmount(Long id, Double remainingAmount);

    void updateDiscount(Long id, Double discount);

    void updateCurrency(Long id, String currency);

    void updatePayInInstallments(Long id, Boolean payInInstallments);

    void updateInsideEgypt(Long id, Boolean insideEgypt);


    void updateReview(Long id, String review);

    void updateRating(Long id, String rating);

    void updateDescription(Long id, String description);

    void updatePaymentStatus(Long id, Long paymentStatusId);

    void updatePaymentMethod(Long id, Long paymentMethodId);

    void updateActionTaken(Long id, Long actionTakenId);

    void updateReferralSource(Long id, Long referralSourceId);

    void updateClient(Long id, Long clientId);

    void updateCourse(Long id, Long courseId);

    void updateIsReceived(Long id, Boolean isReceived);

    void updateTotalAmount(Long id, Double totalAmount);
}
