package com.example.coursemanagementapp.service;

import com.example.backendcoreservice.api.pagination.PaginationRequest;
import com.example.backendcoreservice.api.pagination.PaginationResponse;
import com.example.coursemanagementapp.dao.EvaluationDao;
import com.example.coursemanagementapp.dto.EvaluationDto;
import com.example.coursemanagementapp.dto.HistoryDto;
import com.example.coursemanagementapp.dto.search.EvaluationSearchDto;
import com.example.coursemanagementapp.model.Enrollment;
import com.example.coursemanagementapp.model.Evaluation;
import com.example.coursemanagementapp.transformer.EvaluationTransformer;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class EvaluationServiceImpl implements EvaluationService {

    private final EvaluationDao evaluationDao;
    private final EvaluationTransformer evaluationTransformer;
    private final HistoryService historyService;
    private final EvaluationStatusService evaluationStatusService;
    private final EnrollmentService enrollmentService;

    @Override
    public EvaluationDao getDao() {
        return evaluationDao;
    }

    @Override
    public EvaluationTransformer getTransformer() {
        return evaluationTransformer;
    }

    @Override
    public String getEntityName() {
        return Evaluation.class.getSimpleName();
    }

    @SneakyThrows
    @Override
    public Evaluation doBeforeCreate(Evaluation entity, EvaluationDto dto) {
        log.info("EvaluationServiceImpl: doBeforeCreate() - was called");
        entity.setEnrollment(enrollmentService.findEntityById(dto.getEnrollmentId()));
        entity.setEnrollmentId(dto.getEnrollmentId());
        entity.setEvaluationStatus(evaluationStatusService.findEntityById(dto.getEvaluationStatusId()));
        return entity;
    }

    @Override
    public PaginationResponse<EvaluationDto> findAllPaginatedAndFiltered(PaginationRequest<EvaluationSearchDto> paginationRequest) {
        return buildPaginationResponse(getDao().findAllPaginatedAndFiltered(paginationRequest));
    }

    @Transactional
    @Override
    public void updateExamName(EvaluationDto evaluationDto, Long id) {
        log.info("EvaluationService: updateExamName() - was called");
        EvaluationDto evaluationDtoDb = findById(id);
        historyService.create(HistoryDto.HistoryDtoBuilder()
                .entityType(getEntityName())
                .entityId(evaluationDtoDb.getId())
                .fieldName("examName")
                .oldValue(evaluationDtoDb.getExamName())
                .newValue(evaluationDto.getExamName())
                .build());
        getDao().updateExamName(id, evaluationDto.getExamName());

    }

    @Transactional
    @Override
    public void updateEvaluationStatus(Long id, Long evaluationStatusId) {
        log.info("EvaluationService: updateEvaluationStatus() - was called");
        if (!evaluationStatusService.existsById(evaluationStatusId)) {
            throw new EntityNotFoundException("EvaluationStatus with id: " + evaluationStatusId + " not found");
        }
        EvaluationDto evaluationDtoDb = findById(id);
        historyService.create(HistoryDto.HistoryDtoBuilder()
                .entityType(getEntityName())
                .entityId(evaluationDtoDb.getId())
                .fieldName("evaluationStatus")
                .oldValue(evaluationDtoDb.getEvaluationStatus() == null ? "" : evaluationDtoDb.getEvaluationStatus().getStatus().getStatus())
                .newValue(evaluationStatusService.findById(evaluationStatusId).getStatus().getStatus())
                .build());
        getDao().updateEvaluationStatus(id, evaluationStatusId);
    }
}
