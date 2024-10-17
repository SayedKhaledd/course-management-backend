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

    void updateName(Long id, ClientDto clientDto);

    void updateStatus(Long id, Long statusId);

    void updateDescription(Long id, ClientDto clientDto);

    void updateEmail(Long id, ClientDto clientDto);

    void updatePhone(Long id, ClientDto clientDto);

    void updateAlternativePhone(Long id, ClientDto clientDto);

    void updateCountry(Long id, ClientDto clientDto);

    void updateNationality(Long id, ClientDto clientDto);

    void updateAddress(Long id, ClientDto clientDto);

    void updateSpecialty(Long id, ClientDto clientDto);

    void updateReferralSource(Long id, Long referralSourceId);
}
