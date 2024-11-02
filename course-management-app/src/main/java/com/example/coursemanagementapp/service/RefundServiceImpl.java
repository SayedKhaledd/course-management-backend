package com.example.coursemanagementapp.service;

import com.example.backendcoreservice.exception.CustomException;
import com.example.coursemanagementapp.dao.RefundDao;
import com.example.coursemanagementapp.dto.HistoryDto;
import com.example.coursemanagementapp.dto.RefundDto;
import com.example.coursemanagementapp.enums.ActionTaken;
import com.example.coursemanagementapp.enums.RefundStatus;
import com.example.coursemanagementapp.model.Enrollment;
import com.example.coursemanagementapp.model.Refund;
import com.example.coursemanagementapp.transformer.RefundTransformer;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class RefundServiceImpl implements RefundService {

    private final RefundDao refundDao;
    private final RefundTransformer refundTransformer;
    private final EnrollmentService enrollmentService;
    private final RefundMethodService refundMethodService;
    private final RefundReasonService refundReasonService;
    private final HistoryService historyService;
    private final RefundStatusService refundStatusService;
    private final ActionTakenService actionTakenService;

    public RefundServiceImpl(RefundDao refundDao, RefundTransformer refundTransformer,
                             @Lazy EnrollmentService enrollmentService, RefundMethodService refundMethodService,
                             RefundReasonService refundReasonService, HistoryService historyService,
                             RefundStatusService refundStatusService, ActionTakenService actionTakenService) {
        this.refundDao = refundDao;
        this.refundTransformer = refundTransformer;
        this.enrollmentService = enrollmentService;
        this.refundMethodService = refundMethodService;
        this.refundReasonService = refundReasonService;
        this.historyService = historyService;
        this.refundStatusService = refundStatusService;
        this.actionTakenService = actionTakenService;
    }

    @Override
    public RefundDao getDao() {
        return refundDao;
    }

    @Override
    public RefundTransformer getTransformer() {
        return refundTransformer;
    }

    @Override
    public String getEntityName() {
        return Refund.class.getSimpleName();
    }

    @Override
    public Refund doBeforeCreate(Refund entity, RefundDto dto) {
        log.info("RefundServiceImpl: doBeforeCreate() - was called");
        Enrollment enrollment = enrollmentService.findEntityByClientIdAndCourseId(dto.getEnrollment().getClientId(), dto.getEnrollment().getCourseId());
        entity.setEnrollmentId(enrollment.getId());
        entity.setEnrollment(enrollment);
        entity.setEnrollmentAmount(enrollment.getAmountPaid());
        entity.setRefundedAmount(dto.getRefundedAmount() == null ? enrollment.getAmountPaid() : dto.getRefundedAmount());
        entity.setRefundStatus(refundStatusService.findEntityByStatus(RefundStatus.WAITING));
        entity.setPaymentMethod(enrollment.getPaymentMethod());
        entity.setIsReceived(false);
//        if (!enrollment.getActionTaken().equals(actionTakenService.findEntityByName(ActionTaken.REFUND)))
//            throw new CustomException("This enrollment does not support refunds");
        return entity;
    }


    @Transactional
    @Override
    public void updateRefundedAmount(Long id, RefundDto dto) {
        log.info("RefundServiceImpl: updateAmount() - was called");
        RefundDto refundDtoDb = findById(id);
        historyService.create(HistoryDto.HistoryDtoBuilder()
                .entityType(getEntityName())
                .entityId(refundDtoDb.getId())
                .fieldName("amount")
                .oldValue(refundDtoDb.getRefundedAmount() + "")
                .newValue(dto.getRefundedAmount() + "")
                .build());
        getDao().updateRefundedAmount(id, dto.getRefundedAmount());
    }

    @Transactional
    @Override
    public void updateRefundDate(Long id, RefundDto dto) {
        log.info("RefundServiceImpl: updateRefundDate() - was called");
        RefundDto refundDtoDb = findById(id);
        historyService.create(HistoryDto.HistoryDtoBuilder()
                .entityType(getEntityName())
                .entityId(refundDtoDb.getId())
                .fieldName("refundDate")
                .oldValue(refundDtoDb.getRefundDate() + "")
                .newValue(dto.getRefundDate() + "")
                .build());
        getDao().updateRefundDate(id, dto.getRefundDate());

    }

    @Transactional
    @Override
    public void updateFirstExplanation(Long id, RefundDto dto) {
        log.info("RefundServiceImpl: updateFirstExplanation() - was called");
        RefundDto refundDtoDb = findById(id);
        historyService.create(HistoryDto.HistoryDtoBuilder()
                .entityType(getEntityName())
                .entityId(refundDtoDb.getId())
                .fieldName("firstExplanation")
                .oldValue(refundDtoDb.getFirstExplanation())
                .newValue(dto.getFirstExplanation())
                .build());
        getDao().updateFirstExplanation(id, dto.getFirstExplanation());
    }

    @Transactional
    @Override
    public void updateSecondExplanation(Long id, RefundDto dto) {
        log.info("RefundServiceImpl: updateSecondExplanation() - was called");
        RefundDto refundDtoDb = findById(id);
        historyService.create(HistoryDto.HistoryDtoBuilder()
                .entityType(getEntityName())
                .entityId(refundDtoDb.getId())
                .fieldName("secondExplanation")
                .oldValue(refundDtoDb.getSecondExplanation())
                .newValue(dto.getSecondExplanation())
                .build());
        getDao().updateSecondExplanation(id, dto.getSecondExplanation());

    }

    @Transactional
    @Override
    public void updateRefundReason(Long id, Long refundReasonId) {
        log.info("RefundServiceImpl: updateRefundReason() - was called");
        if (!refundReasonService.existsById(refundReasonId)) {
            throw new EntityNotFoundException("Refund reason is not found");
        }
        RefundDto refundDtoDb = findById(id);
        historyService.create(HistoryDto.HistoryDtoBuilder()
                .entityType(getEntityName())
                .entityId(refundDtoDb.getId())
                .fieldName("refundReason")
                .oldValue(refundDtoDb.getRefundReason() == null ? "" : refundDtoDb.getRefundReason().getReason().getReason())
                .newValue(refundReasonService.findById(refundReasonId).getReason().getReason())
                .build());
        getDao().updateRefundReason(id, refundReasonId);

    }

    @Transactional
    @Override
    public void updateRefundMethod(Long id, Long refundMethodId) {
        log.info("RefundServiceImpl: updateRefundMethod() - was called");
        if (!refundMethodService.existsById(refundMethodId)) {
            throw new EntityNotFoundException("Refund method is not found");
        }
        RefundDto refundDtoDb = findById(id);
        historyService.create(HistoryDto.HistoryDtoBuilder()
                .entityType(getEntityName())
                .entityId(refundDtoDb.getId())
                .fieldName("refundMethod")
                .oldValue(refundDtoDb.getRefundMethod() == null ? "" : refundDtoDb.getRefundMethod().getMethod().getMethod())
                .newValue(refundMethodService.findById(refundMethodId).getMethod().getMethod())
                .build());
        getDao().updateRefundMethod(id, refundMethodId);
    }

    @Transactional
    @Override
    public void updateRefundStatus(Long id, Long refundStatusId) {
        log.info("RefundServiceImpl: updateRefundStatus() - was called");
        if (!refundStatusService.existsById(refundStatusId)) {
            throw new EntityNotFoundException("Refund status is not found");
        }
        RefundDto refundDtoDb = findById(id);
        historyService.create(HistoryDto.HistoryDtoBuilder()
                .entityType(getEntityName())
                .entityId(refundDtoDb.getId())
                .fieldName("refundStatus")
                .oldValue(refundDtoDb.getRefundStatus().getStatus().getStatus())
                .newValue(refundStatusService.findById(refundStatusId).getStatus().getStatus())
                .build());
        getDao().updateRefundStatus(id, refundStatusId);

        if (refundStatusService.findById(refundStatusId).getStatus().equals(RefundStatus.CANCEL)) {
            enrollmentService.updateActionTaken(refundDtoDb.getEnrollmentId(), actionTakenService.findEntityByName(ActionTaken.ENROLLED).getId());
        }

    }

    @Transactional
    @Override
    public void updateIsReceived(Long id, Boolean isReceived) {
        log.info("RefundServiceImpl: updateIsReceived() - was called");
        RefundDto refundDtoDb = findById(id);
        historyService.create(HistoryDto.HistoryDtoBuilder()
                .entityType(getEntityName())
                .entityId(refundDtoDb.getId())
                .fieldName("isReceived")
                .oldValue(refundDtoDb.getIsReceived() + "")
                .newValue(isReceived + "")
                .build());
        getDao().updateIsReceived(id, isReceived);
    }
}
