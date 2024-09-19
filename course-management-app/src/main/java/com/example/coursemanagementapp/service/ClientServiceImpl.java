package com.example.coursemanagementapp.service;

import com.example.backendcoreservice.api.pagination.PaginationRequest;
import com.example.backendcoreservice.api.pagination.PaginationResponse;
import com.example.backendcoreservice.exception.CustomException;
import com.example.coursemanagementapp.dao.ClientDao;
import com.example.coursemanagementapp.dto.ClientDto;
import com.example.coursemanagementapp.dto.ClientHistoryDto;
import com.example.coursemanagementapp.dto.ClientSearchDto;
import com.example.coursemanagementapp.transformer.ClientTransformer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientDao clientDao;
    private final ClientTransformer clientTransformer;
    private final ClientStatusService clientStatusService;
    private final ClientHistoryService clientHistoryService;

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

    @Transactional
    @Override
    public void updateStatus(Long id, Long statusId) {
        log.info("ClientService: updateStatus() - was called");
        ClientDto clientDto = findById(id);
        if (!clientStatusService.existsById(statusId))
            throw new CustomException("Status with id " + statusId + " does not exist");
        clientHistoryService.create(ClientHistoryDto.ClientHistoryDtoBuilder()
                .clientId(id)
                .client(clientDto)
                .fieldName("status")
                .oldValue(clientDto.getClientStatusId().toString())
                .newValue(statusId.toString())
                .build());
        getDao().updateStatus(id, statusId);
    }

    @Transactional
    @Override
    public void updateDescription(Long id, ClientDto clientDto) {
        log.info("ClientService: updateDescription() - was called");
        ClientDto clientDtoDb = findById(id);
        clientHistoryService.create(ClientHistoryDto.ClientHistoryDtoBuilder()
                .clientId(id)
                .client(clientDtoDb)
                .fieldName("description")
                .oldValue(clientDtoDb.getDescription())
                .newValue(clientDto.getDescription())
                .build());
        getDao().updateDescription(id, clientDto.getDescription());
    }

}
