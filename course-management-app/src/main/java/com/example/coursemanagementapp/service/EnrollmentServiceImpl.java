package com.example.coursemanagementapp.service;

import com.example.backendcoreservice.api.pagination.PaginationRequest;
import com.example.backendcoreservice.api.pagination.PaginationResponse;
import com.example.coursemanagementapp.dao.EnrollmentDao;
import com.example.coursemanagementapp.dto.*;
import com.example.coursemanagementapp.dto.search.EnrollmentSearchDto;
import com.example.coursemanagementapp.enums.ActionTaken;
import com.example.coursemanagementapp.enums.ClientStatus;
import com.example.coursemanagementapp.enums.PaymentStatus;
import com.example.coursemanagementapp.enums.ReferralSource;
import com.example.coursemanagementapp.model.Enrollment;
import com.example.coursemanagementapp.transformer.EnrollmentTransformer;
import com.example.coursemanagementapp.validator.EnrollmentValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@AllArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentDao enrollmentDao;
    private final EnrollmentTransformer enrollmentTransformer;
    private final HistoryService historyService;
    private final CourseService courseService;
    private final ClientService clientService;
    private final ReferralSourceService referralSourceService;
    private final PaymentStatusService paymentStatusService;
    private final PaymentMethodService paymentMethodService;
    private final ActionTakenService actionTakenService;
    private final InstallmentService installmentService;
    private final RefundService refundService;
    private final EnrollmentValidator enrollmentValidator;
    private final ClientStatusService clientStatusService;

    @Override
    public EnrollmentDao getDao() {
        return enrollmentDao;
    }

    @Override
    public EnrollmentTransformer getTransformer() {
        return enrollmentTransformer;
    }

    @Override
    public String getEntityName() {
        return Enrollment.class.getSimpleName();
    }

    //TODO: MAY CHANGE THE DEFAULT REFERRAL SOURCE
    @SneakyThrows
    @Override
    public Enrollment doBeforeCreate(Enrollment entity, EnrollmentDto dto) {
        entity.setCourse(courseService.findEntityById(dto.getCourseId()));
        entity.setClient(clientService.findEntityById(dto.getClientId()));
        entity.setTotalAmount(dto.getTotalAmount() == null || dto.getTotalAmount() == 0 ? entity.getCourse().getPrice() : dto.getTotalAmount());
        entity.setAmountPaid(dto.getAmountPaid() == null ? 0.0 : dto.getAmountPaid());
        entity.setRemainingAmount(entity.getTotalAmount() - entity.getAmountPaid());
        entity.setReferralSource(dto.getReferralSourceId() == null ? (entity.getClient().getReferralSource() == null ? referralSourceService.findEntityByName(ReferralSource.REGISTRATION) : entity.getClient().getReferralSource()) :
                referralSourceService.findEntityById(dto.getReferralSourceId()));
        entity.setActionTaken(dto.getActionTakenId() == null ? actionTakenService.findEntityByName(ActionTaken.ENROLLED) : actionTakenService.findEntityById(dto.getActionTakenId()));
        entity.setDiscount(dto.getDiscount() == null ? 0.0 : dto.getDiscount());
        entity.setPaymentMethod(dto.getPaymentMethodId() != null ? paymentMethodService.findEntityById(dto.getPaymentMethodId()) : null);
        entity.setPaymentStatus(dto.getPaymentStatusId() != null ? paymentStatusService.findEntityById(dto.getPaymentStatusId()) : paymentStatusService.findEntityByName(PaymentStatus.WAITING));
        return entity;
    }

    @Override
    public EnrollmentDto create(EnrollmentDto dto) {
        EnrollmentDto enrollmentDto = EnrollmentService.super.create(dto);
        clientService.updateStatus(enrollmentDto.getClientId(), clientStatusService.findEntityByName(ClientStatus.COURSE_RESERVED).getId());
        if (!Objects.equals(enrollmentDto.getAmountPaid(), enrollmentDto.getTotalAmount())) {
            enrollmentDto.setPayInInstallments(true);
            installmentService.create(InstallmentDto.InstallmentDtoBuilder()
                    .enrollmentId(enrollmentDto.getId())
                    .amount(enrollmentDto.getRemainingAmount())
                    .dueDate(enrollmentDto.getModifiedDate())
                    .isReceived(false)
                    .build());
            enrollmentDto = update(enrollmentDto, enrollmentDto.getId());
        }

        return enrollmentDto;
    }

    @Override
    public List<EnrollmentDto> findAllByClientId(Long clientId) {
        log.info("EnrollmentService: findAllByClientId() called with clientId: {}", clientId);
        return getTransformer().transformEntitiesToDtos(getDao().findAllByClientId(clientId));
    }

    @Override
    public List<EnrollmentDto> findAllByCourseId(Long courseId) {
        log.info("EnrollmentService: findAllByCourseId() called with courseId: {}", courseId);
        return getTransformer().transformEntitiesToDtos(getDao().findAllByCourseId(courseId));
    }

    @Override
    public EnrollmentDto findByClientIdAndCourseId(Long clientId, Long courseId) {
        log.info("EnrollmentService: findByClientIdAndCourseId() called with clientId: {} and courseId: {}", clientId, courseId);
        return getTransformer().transformEntityToDto(getDao().findByClientIdAndCourseId(clientId, courseId));
    }

    @Override
    public Enrollment findEntityByClientIdAndCourseId(Long clientId, Long courseId) {
        log.info("EnrollmentService: findEntityByClientIdAndCourseId() called with clientId: {} and courseId: {}", clientId, courseId);
        return getDao().findByClientIdAndCourseId(clientId, courseId);
    }

    @Override
    public PaginationResponse<EnrollmentDto> findAllPaginatedAndFiltered(PaginationRequest<EnrollmentSearchDto> paginationRequest) {
        log.info("EnrollmentService: findAllPaginatedAndFiltered() called");
        return buildPaginationResponse(getDao().findAllPaginatedAndFiltered(paginationRequest));
    }

    @Transactional
    @Override
    public void updateAmountPaid(Long id, EnrollmentDto dto) {
        log.info("EnrollmentService: updateAmountPaid() called with id: {} and dto: {}", id, dto);
        EnrollmentDto enrollmentDtoDb = findById(id);
        historyService.create(HistoryDto.HistoryDtoBuilder()
                .entityId(id)
                .entityType(getEntityName())
                .fieldName("amountPaid")
                .oldValue(enrollmentDtoDb.getAmountPaid() + "")
                .newValue(dto.getAmountPaid() + "")
                .build());
        getDao().updateAmountPaid(id, dto.getAmountPaid());
        updateRemainingAmount(id, dto.getAmountPaid(), enrollmentDtoDb.getTotalAmount());
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void updateRemainingAmount(Long id, Double paidAmount, Double totalAmount) {
        log.info("EnrollmentService: updateRemainingAmount() called with id: {} and paidAmount: {}", id, paidAmount);
        EnrollmentDto enrollmentDtoDb = findById(id);
        Double remainingAmount = totalAmount - paidAmount;
        historyService.create(HistoryDto.HistoryDtoBuilder()
                .entityId(id)
                .entityType(getEntityName())
                .fieldName("remainingAmount")
                .oldValue(enrollmentDtoDb.getRemainingAmount() + "")
                .newValue(remainingAmount + "")
                .build());
        getDao().updateRemainingAmount(id, remainingAmount);
    }

    @Transactional
    @Override
    public void updateTotalAmount(Long id, Double totalAmount) {
        log.info("EnrollmentService: updateTotalAmount() called with id: {} and totalAmount: {}", id, totalAmount);
        EnrollmentDto enrollmentDtoDb = findById(id);
        historyService.create(HistoryDto.HistoryDtoBuilder()
                .entityId(id)
                .entityType(getEntityName())
                .fieldName("totalAmount")
                .oldValue(enrollmentDtoDb.getTotalAmount() + "")
                .newValue(totalAmount + "")
                .build());
        getDao().updateTotalAmount(id, totalAmount);
        updateRemainingAmount(id, enrollmentDtoDb.getAmountPaid(), totalAmount);
    }

    @Transactional
    @Override
    public void updateDiscount(Long id, EnrollmentDto dto) {
        log.info("EnrollmentService: updateDiscount() called with id: {} and dto: {}", id, dto);
        EnrollmentDto enrollmentDtoDb = findById(id);
        historyService.create(HistoryDto.HistoryDtoBuilder()
                .entityId(id)
                .entityType(getEntityName())
                .fieldName("discount")
                .oldValue(enrollmentDtoDb.getDiscount() + "")
                .newValue(dto.getDiscount() + "")
                .build());
        getDao().updateDiscount(id, dto.getDiscount());
        updateTotalAmount(id, enrollmentDtoDb.getTotalAmount() - enrollmentDtoDb.getTotalAmount() * dto.getDiscount());

    }

    @Transactional
    @Override
    public void updateCurrency(Long id, EnrollmentDto dto) {
        log.info("EnrollmentService: updateCurrency() called with id: {} and dto: {}", id, dto);
        EnrollmentDto enrollmentDtoDb = findById(id);
        historyService.create(HistoryDto.HistoryDtoBuilder()
                .entityId(id)
                .entityType(getEntityName())
                .fieldName("currency")
                .oldValue(enrollmentDtoDb.getCurrency())
                .newValue(dto.getCurrency())
                .build());
        getDao().updateCurrency(id, dto.getCurrency());

    }

    @Transactional
    @Override
    public void updatePayInInstallments(Long id, Boolean payInInstallments) {
        log.info("EnrollmentService: updatePayInInstallments() called with id: {} and payInInstallments: {}", id, payInInstallments);
        EnrollmentDto enrollmentDtoDb = findById(id);
        historyService.create(HistoryDto.HistoryDtoBuilder()
                .entityId(id)
                .entityType(getEntityName())
                .fieldName("payInInstallments")
                .oldValue(enrollmentDtoDb.getPayInInstallments() + "")
                .newValue(payInInstallments + "")
                .build());
        getDao().updatePayInInstallments(id, payInInstallments);
        if (payInInstallments) {
            installmentService.create(InstallmentDto.InstallmentDtoBuilder()
                    .enrollment(enrollmentDtoDb)
                    .amount(enrollmentDtoDb.getRemainingAmount())
                    .dueDate(enrollmentDtoDb.getModifiedDate())
                    .isReceived(false)
                    .build());
        }

    }

    @Transactional
    @Override
    public void updateInsideEgypt(Long id, Boolean insideEgypt) {
        log.info("EnrollmentService: updateInsideEgypt() called with id: {} and insideEgypt: {}", id, insideEgypt);
        EnrollmentDto enrollmentDtoDb = findById(id);
        historyService.create(HistoryDto.HistoryDtoBuilder()
                .entityId(id)
                .entityType(getEntityName())
                .fieldName("insideEgypt")
                .oldValue(enrollmentDtoDb.getInsideEgypt() + "")
                .newValue(insideEgypt + "")
                .build());
        getDao().updateInsideEgypt(id, insideEgypt);

    }

    @Transactional
    @Override
    public void updateReview(Long id, EnrollmentDto dto) {
        log.info("EnrollmentService: updateReview() called with id: {} and dto: {}", id, dto);
        EnrollmentDto enrollmentDtoDb = findById(id);
        historyService.create(HistoryDto.HistoryDtoBuilder()
                .entityId(id)
                .entityType(getEntityName())
                .fieldName("review")
                .oldValue(enrollmentDtoDb.getReview())
                .newValue(dto.getReview())
                .build());
        getDao().updateReview(id, dto.getReview());

    }

    @Transactional
    @Override
    public void updateRating(Long id, EnrollmentDto dto) {
        log.info("EnrollmentService: updateRating() called with id: {} and dto: {}", id, dto);
        EnrollmentDto enrollmentDtoDb = findById(id);
        historyService.create(HistoryDto.HistoryDtoBuilder()
                .entityId(id)
                .entityType(getEntityName())
                .fieldName("rating")
                .oldValue(enrollmentDtoDb.getRating())
                .newValue(dto.getRating())
                .build());
        getDao().updateRating(id, dto.getRating());

    }

    @Transactional
    @Override
    public void updateDescription(Long id, EnrollmentDto dto) {
        log.info("EnrollmentService: updateDescription() called with id: {} and dto: {}", id, dto);
        EnrollmentDto enrollmentDtoDb = findById(id);
        historyService.create(HistoryDto.HistoryDtoBuilder()
                .entityId(id)
                .entityType(getEntityName())
                .fieldName("description")
                .oldValue(enrollmentDtoDb.getDescription())
                .newValue(dto.getDescription())
                .build());
        getDao().updateDescription(id, dto.getDescription());

    }

    @Transactional
    @Override
    public void updatePaymentStatus(Long id, Long paymentStatusId) {
        log.info("EnrollmentService: updatePaymentStatus() called with id: {} and paymentStatusId: {}", id, paymentStatusId);
        EnrollmentDto enrollmentDtoDb = findById(id);
        if (!paymentStatusService.existsById(paymentStatusId))
            throw new EntityNotFoundException("PaymentStatus with id: " + paymentStatusId + " does not exist");
        historyService.create(HistoryDto.HistoryDtoBuilder()
                .entityId(id)
                .entityType(getEntityName())
                .fieldName("paymentStatus")
                .oldValue(enrollmentDtoDb.getPaymentStatus() == null ? "" : enrollmentDtoDb.getPaymentStatus().getStatus().getStatus())
                .newValue(paymentStatusService.findById(paymentStatusId).getStatus().getStatus())
                .build());
        getDao().updatePaymentStatus(id, paymentStatusId);
    }

    @Transactional
    @Override
    public void updatePaymentMethod(Long id, Long paymentMethodId) {
        log.info("EnrollmentService: updatePaymentMethod() called with id: {} and paymentMethodId: {}", id, paymentMethodId);
        EnrollmentDto enrollmentDtoDb = findById(id);
        if (!paymentMethodService.existsById(paymentMethodId))
            throw new EntityNotFoundException("PaymentMethod with id: " + paymentMethodId + " does not exist");
        historyService.create(HistoryDto.HistoryDtoBuilder()
                .entityId(id)
                .entityType(getEntityName())
                .fieldName("paymentMethod")
                .oldValue(enrollmentDtoDb.getPaymentMethod() == null ? "" : enrollmentDtoDb.getPaymentMethod().getMethod().getMethod())
                .newValue(paymentMethodService.findById(paymentMethodId).getMethod().getMethod())
                .build());
        getDao().updatePaymentMethod(id, paymentMethodId);

    }

    @Transactional
    @Override
    public void updateActionTaken(Long id, Long actionTakenId) {
        log.info("EnrollmentService: updateActionTaken() called with id: {} and actionTakenId: {}", id, actionTakenId);
        EnrollmentDto enrollmentDtoDb = findById(id);
        ActionTakenDto actionTakenDto = actionTakenService.findById(actionTakenId);
        historyService.create(HistoryDto.HistoryDtoBuilder()
                .entityId(id)
                .entityType(getEntityName())
                .fieldName("actionTaken")
                .oldValue(enrollmentDtoDb.getActionTaken() == null ? "" : enrollmentDtoDb.getActionTaken().getAction().getAction())
                .newValue(actionTakenDto.getAction().getAction())
                .build());
        getDao().updateActionTaken(id, actionTakenId);
        if (enrollmentValidator.shouldCreateRefund(enrollmentDtoDb, actionTakenDto)) {
            refundService.create(RefundDto.RefundDtoBuilder()
                    .enrollment(enrollmentDtoDb)
                    .isReceived(false)
                    .build());
        }

    }

    @Transactional
    @Override
    public void updateReferralSource(Long id, Long referralSourceId) {
        log.info("EnrollmentService: updateReferralSource() called with id: {} and referralSourceId: {}", id, referralSourceId);
        EnrollmentDto enrollmentDtoDb = findById(id);
        if (!referralSourceService.existsById(referralSourceId))
            throw new EntityNotFoundException("ReferralSource with id: " + referralSourceId + " does not exist");
        historyService.create(HistoryDto.HistoryDtoBuilder()
                .entityId(id)
                .entityType(getEntityName())
                .fieldName("referralSource")
                .oldValue(enrollmentDtoDb.getReferralSource() == null ? "" : enrollmentDtoDb.getReferralSource().getSource().getSource())
                .newValue(referralSourceService.findById(referralSourceId).getSource().getSource())
                .build());
        getDao().updateReferralSource(id, referralSourceId);
    }

    @Transactional
    @Override
    public void updateClient(Long id, Long clientId) {
        log.info("EnrollmentService: updateClient() called with id: {} and clientId: {}", id, clientId);
        EnrollmentDto enrollmentDtoDb = findById(id);
        if (!clientService.existsById(clientId))
            throw new EntityNotFoundException("Client with id: " + clientId + " does not exist");
        historyService.create(HistoryDto.HistoryDtoBuilder()
                .entityId(id)
                .entityType(getEntityName())
                .fieldName("client")
                .oldValue(enrollmentDtoDb.getClientId() + "")
                .newValue(clientId + "")
                .build());
        getDao().updateClient(id, clientId);
    }

    @Transactional
    @Override
    public void updateCourse(Long id, Long courseId) {
        log.info("EnrollmentService: updateCourse() called with id: {} and courseId: {}", id, courseId);
        EnrollmentDto enrollmentDtoDb = findById(id);
        if (!courseService.existsById(courseId))
            throw new EntityNotFoundException("Course with id: " + courseId + " does not exist");
        historyService.create(HistoryDto.HistoryDtoBuilder()
                .entityId(id)
                .entityType(getEntityName())
                .fieldName("course")
                .oldValue(enrollmentDtoDb.getCourseId() + "")
                .newValue(courseId + "")
                .build());
        getDao().updateCourse(id, courseId);
    }

    @Transactional
    @Override
    public void updateIsReceived(Long id, Boolean isReceived) {
        log.info("EnrollmentService: updateIsReceived() called with id: {} and isReceived: {}", id, isReceived);
        EnrollmentDto enrollmentDtoDb = findById(id);
        historyService.create(HistoryDto.HistoryDtoBuilder()
                .entityId(id)
                .entityType(getEntityName())
                .fieldName("isReceived")
                .oldValue(enrollmentDtoDb.getIsReceived() + "")
                .newValue(isReceived + "")
                .build());
        getDao().updateIsReceived(id, isReceived);
    }

    @Override
    public void delete(Long id) {
        log.info("EnrollmentService: delete() called with id: {}", id);
        Enrollment enrollment = enrollmentDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Enrollment not found"));
        enrollment.getInstallments().size();
        enrollment.getRefunds().size();
        EnrollmentService.super.delete(id);
    }
}
