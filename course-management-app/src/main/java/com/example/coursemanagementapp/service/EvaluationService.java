package com.example.coursemanagementapp.service;

import com.example.backendcoreservice.api.pagination.PaginationRequest;
import com.example.backendcoreservice.api.pagination.PaginationResponse;
import com.example.backendcoreservice.service.AbstractService;
import com.example.coursemanagementapp.dao.EvaluationDao;
import com.example.coursemanagementapp.dto.EvaluationDto;
import com.example.coursemanagementapp.dto.search.EvaluationSearchDto;
import com.example.coursemanagementapp.model.Evaluation;
import com.example.coursemanagementapp.transformer.EvaluationTransformer;
import jakarta.validation.Valid;

import java.util.List;

public interface EvaluationService extends AbstractService<Evaluation, EvaluationDto, EvaluationTransformer, EvaluationDao> {


    PaginationResponse<EvaluationDto> findAllPaginatedAndFiltered(PaginationRequest<EvaluationSearchDto> paginationRequest);


    void updateExamName(EvaluationDto evaluationDto, Long id);

    void updateEvaluationStatus(Long id, Long evaluationStatusId);
}
