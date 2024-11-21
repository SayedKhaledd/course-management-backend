package com.example.coursemanagementapp.dao;

import com.example.backendcoreservice.api.pagination.PaginationRequest;
import com.example.coursemanagementapp.dao.repo.SalesRepo;
import com.example.coursemanagementapp.dto.search.EnrollmentSearchDto;
import com.example.coursemanagementapp.dto.search.SalesSearchDto;
import com.example.coursemanagementapp.model.Sales;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Slf4j
@AllArgsConstructor
@Component
public class SalesDaoImpl implements SalesDao {

    private final SalesRepo salesRepo;

    @Override
    public SalesRepo getRepo() {
        return salesRepo;
    }

    @Override
    public Page<Sales> findAllPaginatedAndFiltered(PaginationRequest<SalesSearchDto> paginationRequest) {
        log.info("SalesDao: findAllPaginatedAndFiltered - was called with paginationRequest: {}", paginationRequest);
        SalesSearchDto criteria = paginationRequest.getCriteria();
        if (criteria == null)
            return getRepo().findAll(getPageRequest(paginationRequest));

        return getRepo().findAllFilteredAndPaginated(getPageRequest(paginationRequest), criteria);

    }
}
