package com.example.coursemanagementapp.dao;

import com.example.backendcoreservice.api.pagination.PaginationRequest;
import com.example.backendcoreservice.dao.AbstractDao;
import com.example.coursemanagementapp.dao.repo.InstallmentRepo;
import com.example.coursemanagementapp.dto.search.InstallmentSearchDto;
import com.example.coursemanagementapp.model.Installment;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

public interface InstallmentDao extends AbstractDao<Installment, InstallmentRepo> {

   Page<Installment> findAllPaginatedAndFiltered(PaginationRequest<InstallmentSearchDto> paginationRequest);

    void updateAmount(Long id, Double amount);

    void updateDueDate(Long id, LocalDateTime dueDate);

    void updatePaymentDate(Long id, LocalDateTime paymentDate);

    void updatePaymentStatus(Long id, Long paymentStatusId);

    void updatePaymentMethod(Long id, Long paymentMethodId);

    void updateIsReceived(Long id, Boolean isReceived);
}
