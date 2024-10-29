package com.example.coursemanagementapp.service;

import com.example.backendcoreservice.exception.CustomException;
import com.example.coursemanagementapp.dao.InstallmentDao;
import com.example.coursemanagementapp.dto.EnrollmentDto;
import com.example.coursemanagementapp.dto.HistoryDto;
import com.example.coursemanagementapp.dto.InstallmentDto;
import com.example.coursemanagementapp.enums.PaymentStatus;
import com.example.coursemanagementapp.model.Enrollment;
import com.example.coursemanagementapp.model.Installment;
import com.example.coursemanagementapp.transformer.InstallmentTransformer;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class InstallmentServiceImpl implements InstallmentService {

    private final InstallmentDao installmentDao;
    private final InstallmentTransformer installmentTransformer;
    private final EnrollmentService enrollmentService;
    private final PaymentStatusService paymentStatusService;
    private final PaymentMethodService paymentMethodService;
    private final HistoryService historyService;

    public InstallmentServiceImpl(InstallmentDao installmentDao, InstallmentTransformer installmentTransformer,
                                  @Lazy EnrollmentService enrollmentService, PaymentStatusService paymentStatusService, PaymentMethodService paymentMethodService, HistoryService historyService) {

        this.installmentDao = installmentDao;
        this.installmentTransformer = installmentTransformer;
        this.enrollmentService = enrollmentService;
        this.paymentStatusService = paymentStatusService;
        this.paymentMethodService = paymentMethodService;
        this.historyService = historyService;
    }

    @Override
    public InstallmentDao getDao() {
        return installmentDao;
    }

    @Override
    public InstallmentTransformer getTransformer() {
        return installmentTransformer;
    }

    @Override
    public String getEntityName() {
        return Installment.class.getSimpleName();
    }

    @Override
    public Installment doBeforeCreate(Installment entity, InstallmentDto dto) {
        log.info("InstallmentServiceImpl: doBeforeCreate() - was called");
        Enrollment enrollment = enrollmentService.findEntityByClientIdAndCourseId(dto.getEnrollment().getClientId(), dto.getEnrollment().getCourseId());
        entity.setEnrollmentId(enrollment.getId());
        entity.setEnrollment(enrollment);
        if (enrollment.getRemainingAmount() < dto.getAmount()) {
            throw new CustomException("Amount cannot be greater than remaining amount");
        }
        return entity;
    }

    @Transactional
    @Override
    public void updateAmount(Long id, InstallmentDto dto) {
        log.info("InstallmentServiceImpl: updateAmount() - was called");
        InstallmentDto installmentDtoDb = findById(id);
        historyService.create(HistoryDto.HistoryDtoBuilder()
                .entityType(getEntityName())
                .entityId(installmentDtoDb.getId())
                .fieldName("amount")
                .oldValue(installmentDtoDb.getAmount() + "")
                .newValue(dto.getAmount() + "")
                .build());
        getDao().updateAmount(id, dto.getAmount());
    }

    @Transactional
    @Override
    public void updateDueDate(Long id, InstallmentDto dto) {
        log.info("InstallmentServiceImpl: updateDueDate() - was called");
        InstallmentDto installmentDtoDb = findById(id);
        historyService.create(HistoryDto.HistoryDtoBuilder()
                .entityId(id)
                .entityType(getEntityName())
                .fieldName("dueDate")
                .oldValue(installmentDtoDb.getDueDate() + "")
                .newValue(dto.getDueDate() + "")
                .build());
        getDao().updateDueDate(id, dto.getDueDate());

    }

    @Transactional
    @Override
    public void updatePaymentDate(Long id, InstallmentDto dto) {
        log.info("InstallmentServiceImpl: updatePaymentDate() - was called");
        InstallmentDto installmentDtoDb = findById(id);
        historyService.create(HistoryDto.HistoryDtoBuilder()
                .entityId(id)
                .entityType(getEntityName())
                .fieldName("paymentDate")
                .oldValue(installmentDtoDb.getPaymentDate() + "")
                .newValue(dto.getPaymentDate() + "")
                .build());

        getDao().updatePaymentDate(id, dto.getPaymentDate());

    }

    @Transactional
    @Override
    public void updatePaymentStatus(Long id, Long paymentStatusId) {
        log.info("InstallmentServiceImpl: updatePaymentStatus() - was called");
        if (!paymentStatusService.existsById(paymentStatusId)) {
            throw new EntityNotFoundException("Payment status is not found");
        }
        InstallmentDto installmentDtoDb = findById(id);
        historyService.create(HistoryDto.HistoryDtoBuilder()
                .entityId(id)
                .entityType(getEntityName())
                .fieldName("paymentStatus")
                .oldValue(installmentDtoDb.getPaymentStatus() == null ? "" : installmentDtoDb.getPaymentStatus().getStatus().getStatus())
                .newValue(paymentStatusService.findById(paymentStatusId).getStatus().getStatus())
                .build());
        getDao().updatePaymentStatus(id, paymentStatusId);
        if (paymentStatusService.findById(paymentStatusId).getStatus().equals(PaymentStatus.PAID)) {
            enrollmentService.updateAmountPaid(installmentDtoDb.getEnrollmentId(),
                    EnrollmentDto.EnrollmentDtoBuilder()
                            .amountPaid(installmentDtoDb.getAmount())
                            .build());
        }

    }

    @Transactional
    @Override
    public void updatePaymentMethod(Long id, Long paymentMethodId) {
        log.info("InstallmentServiceImpl: updatePaymentMethod() - was called");
        if (!paymentMethodService.existsById(paymentMethodId)) {
            throw new EntityNotFoundException("Payment method is not found");
        }
        InstallmentDto installmentDtoDb = findById(id);
        historyService.create(HistoryDto.HistoryDtoBuilder()
                .entityId(id)
                .entityType(getEntityName())
                .fieldName("paymentMethod")
                .oldValue(installmentDtoDb.getPaymentMethod() == null ? "" : installmentDtoDb.getPaymentMethod().getMethod().getMethod())
                .newValue(paymentMethodService.findById(paymentMethodId).getMethod().getMethod())
                .build());

        getDao().updatePaymentMethod(id, paymentMethodId);
    }

    @Transactional
    @Override
    public void updateIsReceived(Long id, Boolean isReceived) {
        log.info("InstallmentServiceImpl: updateIsReceived() - was called");
        InstallmentDto installmentDtoDb = findById(id);
        historyService.create(HistoryDto.HistoryDtoBuilder()
                .entityId(id)
                .entityType(getEntityName())
                .fieldName("isReceived")
                .oldValue(installmentDtoDb.getIsReceived() + "")
                .newValue(isReceived + "")
                .build());
        getDao().updateIsReceived(id, isReceived);
    }
}
