package com.example.coursemanagementapp.service;

import com.example.backendcoreservice.api.pagination.PaginationRequest;
import com.example.backendcoreservice.api.pagination.PaginationResponse;
import com.example.backendcoreservice.service.AbstractService;
import com.example.coursemanagementapp.dao.InstallmentDao;
import com.example.coursemanagementapp.dto.InstallmentDto;
import com.example.coursemanagementapp.dto.search.InstallmentSearchDto;
import com.example.coursemanagementapp.model.Installment;
import com.example.coursemanagementapp.transformer.InstallmentTransformer;

public interface InstallmentService extends AbstractService<Installment, InstallmentDto, InstallmentTransformer, InstallmentDao> {

    PaginationResponse<InstallmentDto> findAllPaginatedAndFiltered(PaginationRequest<InstallmentSearchDto> paginationRequest);

    void updateAmount(Long id, InstallmentDto dto);

    void updateDueDate(Long id, InstallmentDto dto);

    void updatePaymentDate(Long id, InstallmentDto dto);

    void updatePaymentStatus(Long id, Long paymentStatusId);

    void updatePaymentMethod(Long id, Long paymentMethodId);

    void updateIsReceived(Long id, Boolean isReceived);

}
