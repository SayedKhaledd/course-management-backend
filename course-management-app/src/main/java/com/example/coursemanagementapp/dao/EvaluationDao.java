package com.example.coursemanagementapp.dao;

import com.example.backendcoreservice.api.pagination.PaginationRequest;
import com.example.backendcoreservice.dao.AbstractDao;
import com.example.coursemanagementapp.dao.repo.EvaluationRepo;
import com.example.coursemanagementapp.dto.search.EvaluationSearchDto;
import com.example.coursemanagementapp.model.Evaluation;
import org.springframework.data.domain.Page;

public interface EvaluationDao extends AbstractDao<Evaluation, EvaluationRepo> {

    Page<Evaluation> findAllPaginatedAndFiltered(PaginationRequest<EvaluationSearchDto> paginationRequest);

    void updateExamName(Long id, String examName);

    void updateEvaluationStatus(Long id, Long evaluationStatusId);

}
