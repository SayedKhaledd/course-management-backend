package com.example.coursemanagementapp.dao;

import com.example.backendcoreservice.api.pagination.PaginationRequest;
import com.example.backendcoreservice.dao.AbstractDao;
import com.example.coursemanagementapp.dao.repo.ClientRepo;
import com.example.coursemanagementapp.dto.ClientSearchDto;
import com.example.coursemanagementapp.model.Client;
import org.springframework.data.domain.Page;

public interface ClientDao extends AbstractDao<Client, ClientRepo> {

    Page<Client> findAllPaginatedAndFiltered(PaginationRequest<ClientSearchDto> paginationRequest);

}
