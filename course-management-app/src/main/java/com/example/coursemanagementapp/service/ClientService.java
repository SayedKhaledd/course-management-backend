package com.example.coursemanagementapp.service;

import com.example.backendcoreservice.api.pagination.PaginationRequest;
import com.example.backendcoreservice.api.pagination.PaginationResponse;
import com.example.backendcoreservice.service.AbstractService;
import com.example.coursemanagementapp.dao.ClientDao;
import com.example.coursemanagementapp.dto.ClientDto;
import com.example.coursemanagementapp.dto.ClientSearchDto;
import com.example.coursemanagementapp.model.Client;
import com.example.coursemanagementapp.transformer.ClientTransformer;

public interface ClientService extends AbstractService<Client, ClientDto, ClientTransformer, ClientDao> {

    PaginationResponse<ClientDto> findAllPaginatedAndFiltered(PaginationRequest<ClientSearchDto> paginationRequest);
}
