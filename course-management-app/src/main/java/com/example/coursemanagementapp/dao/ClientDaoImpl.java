package com.example.coursemanagementapp.dao;

import com.example.backendcoreservice.api.pagination.PaginationRequest;
import com.example.coursemanagementapp.dao.repo.ClientRepo;
import com.example.coursemanagementapp.dto.ClientSearchDto;
import com.example.coursemanagementapp.model.Client;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ClientDaoImpl implements ClientDao {

    private final ClientRepo clientRepo;

    @Override
    public ClientRepo getRepo() {
        return clientRepo;
    }

    @Override
    public Page<Client> findAllPaginatedAndFiltered(PaginationRequest<ClientSearchDto> paginationRequest) {
        log.info("ClientDao: findAllPaginatedAndFiltered() - was called");
        ClientSearchDto criteria = paginationRequest.getCriteria();
        return getRepo().findAllFilteredAndPaginated(PageRequest.of(paginationRequest.getPageNumber(), paginationRequest.getPageSize()),
                criteria.getName(), criteria.getEmail(), criteria.getPhone());
    }
}
