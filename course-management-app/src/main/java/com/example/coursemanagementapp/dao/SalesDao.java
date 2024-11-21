package com.example.coursemanagementapp.dao;

import com.example.backendcoreservice.api.pagination.PaginationRequest;
import com.example.backendcoreservice.dao.AbstractDao;
import com.example.coursemanagementapp.dao.repo.SalesRepo;
import com.example.coursemanagementapp.dto.search.SalesSearchDto;
import com.example.coursemanagementapp.model.Sales;
import org.springframework.data.domain.Page;

public interface SalesDao extends AbstractDao<Sales, SalesRepo> {

    Page<Sales> findAllPaginatedAndFiltered(PaginationRequest<SalesSearchDto> paginationRequest);
}
