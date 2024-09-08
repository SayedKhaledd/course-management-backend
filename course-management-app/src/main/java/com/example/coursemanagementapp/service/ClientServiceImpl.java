package com.example.coursemanagementapp.service;

import com.example.backendcoreservice.api.pagination.PaginationRequest;
import com.example.backendcoreservice.api.pagination.PaginationResponse;
import com.example.coursemanagementapp.dao.ClientDao;
import com.example.coursemanagementapp.dto.ClientDto;
import com.example.coursemanagementapp.dto.ClientSearchDto;
import com.example.coursemanagementapp.transformer.ClientTransformer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientDao clientDao;
    private final ClientTransformer clientTransformer;

    @Override
    public ClientDao getDao() {
        return clientDao;
    }

    @Override
    public ClientTransformer getTransformer() {
        return clientTransformer;
    }

    @Override
    public PaginationResponse<ClientDto> findAllPaginatedAndFiltered(PaginationRequest<ClientSearchDto> paginationRequest) {
        log.info("ClientService: findAllPaginatedAndFiltered() - was called");
        return buildPaginationResponse(getDao().findAllPaginatedAndFiltered(paginationRequest));
    }
}
