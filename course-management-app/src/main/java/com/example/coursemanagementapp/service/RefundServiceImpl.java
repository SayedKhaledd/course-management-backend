package com.example.coursemanagementapp.service;

import com.example.coursemanagementapp.dao.RefundDao;
import com.example.coursemanagementapp.dto.RefundDto;
import com.example.coursemanagementapp.dto.RefundHistoryDto;
import com.example.coursemanagementapp.model.Enrollment;
import com.example.coursemanagementapp.model.Refund;
import com.example.coursemanagementapp.transformer.RefundTransformer;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@AllArgsConstructor
public class RefundServiceImpl implements RefundService {

    private final RefundDao refundDao;
    private final RefundTransformer refundTransformer;
    private final EnrollmentService enrollmentService;
    private final PaymentMethodService paymentMethodService;
    private final RefundReasonService refundReasonService;
    private final RefundHistoryService refundHistoryService;

    @Override
    public RefundDao getDao() {
        return refundDao;
    }

    @Override
    public RefundTransformer getTransformer() {
        return refundTransformer;
    }

    @Override
    public Refund doBeforeCreate(Refund entity, RefundDto dto) {
        log.info("RefundServiceImpl: doBeforeCreate() - was called");
        Enrollment enrollment = enrollmentService.findEntityByClientIdAndCourseId(dto.getEnrollment().getClientId(), dto.getEnrollment().getCourseId());
        entity.setEnrollmentId(enrollment.getId());
        entity.setEnrollment(enrollment);
        return entity;
    }


    @Transactional
    @Override
    public void updateAmount(Long id, RefundDto dto) {
        log.info("RefundServiceImpl: updateAmount() - was called");
        RefundDto refundDtoDb = findById(id);
        refundHistoryService.create(RefundHistoryDto.RefundHistoryDtoBuilder()
                .refund(refundDtoDb)
                .refundId(refundDtoDb.getId())
                .fieldName("amount")
                .oldValue(refundDtoDb.getAmount() + "")
                .newValue(dto.getAmount() + "")
                .build());
        getDao().updateAmount(id, dto.getAmount());
    }

    @Transactional
    @Override
    public void updateRefundDate(Long id, RefundDto dto) {
        log.info("RefundServiceImpl: updateRefundDate() - was called");
        RefundDto refundDtoDb = findById(id);
        refundHistoryService.create(RefundHistoryDto.RefundHistoryDtoBuilder()
                .refund(refundDtoDb)
                .refundId(refundDtoDb.getId())
                .fieldName("refundDate")
                .oldValue(refundDtoDb.getRefundDate() + "")
                .newValue(dto.getRefundDate() + "")
                .build());
        getDao().updateRefundDate(id, dto.getRefundDate());

    }

    @Transactional
    @Override
    public void updateIsConfirmed(Long id, Boolean isConfirmed) {
        log.info("RefundServiceImpl: updateIsConfirmed() - was called");
        RefundDto refundDtoDb = findById(id);
        refundHistoryService.create(RefundHistoryDto.RefundHistoryDtoBuilder()
                .refund(refundDtoDb)
                .refundId(refundDtoDb.getId())
                .fieldName("isConfirmed")
                .oldValue(refundDtoDb.getIsConfirmed() + "")
                .newValue(isConfirmed + "")
                .build());
        getDao().updateIsConfirmed(id, isConfirmed);

    }

    @Transactional
    @Override
    public void updateExplanation(Long id, RefundDto dto) {
        log.info("RefundServiceImpl: updateExplanation() - was called");
        RefundDto refundDtoDb = findById(id);
        refundHistoryService.create(RefundHistoryDto.RefundHistoryDtoBuilder()
                .refund(refundDtoDb)
                .refundId(refundDtoDb.getId())
                .fieldName("explanation")
                .oldValue(refundDtoDb.getExplanation())
                .newValue(dto.getExplanation())
                .build());
        getDao().updateExplanation(id, dto.getExplanation());

    }

    @Transactional
    @Override
    public void updateRefundReason(Long id, Long refundReasonId) {
        log.info("RefundServiceImpl: updateRefundReason() - was called");
        if (!refundReasonService.existsById(refundReasonId)) {
            throw new EntityNotFoundException("Refund reason is not found");
        }
        RefundDto refundDtoDb = findById(id);
        refundHistoryService.create(RefundHistoryDto.RefundHistoryDtoBuilder()
                .refund(refundDtoDb)
                .refundId(refundDtoDb.getId())
                .fieldName("refundReason")
                .oldValue(refundDtoDb.getRefundReason() == null ? "" : refundDtoDb.getRefundReason().getReason().getReason())
                .newValue(refundReasonService.findById(refundReasonId).getReason().getReason())
                .build());
        getDao().updateRefundReason(id, refundReasonId);

    }

    @Transactional
    @Override
    public void updatePaymentMethod(Long id, Long paymentMethodId) {
        log.info("RefundServiceImpl: updatePaymentMethod() - was called");
        if (!paymentMethodService.existsById(paymentMethodId)) {
            throw new EntityNotFoundException("Payment method is not found");
        }
        RefundDto refundDtoDb = findById(id);
        refundHistoryService.create(RefundHistoryDto.RefundHistoryDtoBuilder()
                .refund(refundDtoDb)
                .refundId(refundDtoDb.getId())
                .fieldName("paymentMethod")
                .oldValue(refundDtoDb.getPaymentMethod() == null ? "" : refundDtoDb.getPaymentMethod().getMethod().getMethod())
                .newValue(paymentMethodService.findById(paymentMethodId).getMethod().getMethod())
                .build());
        getDao().updatePaymentMethod(id, paymentMethodId);

    }
}
