package com.example.coursemanagementapp.service;

import com.example.backendcoreservice.service.AbstractService;
import com.example.coursemanagementapp.dao.EnrollmentDao;
import com.example.coursemanagementapp.dto.EnrollmentDto;
import com.example.coursemanagementapp.model.Enrollment;
import com.example.coursemanagementapp.transformer.EnrollmentTransformer;

import java.util.List;

public interface EnrollmentService extends AbstractService<Enrollment, EnrollmentDto, EnrollmentTransformer, EnrollmentDao> {

    List<EnrollmentDto> findAllByClientId(Long clientId);

    List<EnrollmentDto> findAllByCourseId(Long courseId);

    EnrollmentDto findByClientIdAndCourseId(Long clientId, Long courseId);

    Enrollment findEntityByClientIdAndCourseId(Long clientId, Long courseId);

    void updateAmountPaid(Long id, EnrollmentDto dto);

    void updateRemainingAmount(Long id, EnrollmentDto dto);

    void updateDiscount(Long id, EnrollmentDto dto);

    void updateCurrency(Long id, EnrollmentDto dto);

    void updatePayInInstallments(Long id, Boolean payInInstallments);

    void updateInsideEgypt(Long id, Boolean insideEgypt);

    void updateReview(Long id, EnrollmentDto dto);

    void updateRating(Long id, EnrollmentDto dto);

    void updateDescription(Long id, EnrollmentDto dto);

    void updatePaymentStatus(Long id, Long paymentStatusId);

    void updatePaymentMethod(Long id, Long paymentMethodId);

    void updateActionTaken(Long id, Long actionTakenId);

    void updateReferralSource(Long id, Long referralSourceId);

    void updateClient(Long id, Long clientId);

    void updateCourse(Long id, Long courseId);


    void updateIsReceived(Long id, Boolean isReceived);
}
