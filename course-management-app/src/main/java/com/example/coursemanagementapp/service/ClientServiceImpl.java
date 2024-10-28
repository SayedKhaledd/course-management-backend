package com.example.coursemanagementapp.service;

import com.example.backendcoreservice.api.pagination.PaginationRequest;
import com.example.backendcoreservice.api.pagination.PaginationResponse;
import com.example.coursemanagementapp.dao.ClientDao;
import com.example.coursemanagementapp.dto.ClientDto;
import com.example.coursemanagementapp.dto.ClientSearchDto;
import com.example.coursemanagementapp.dto.HistoryDto;
import com.example.coursemanagementapp.model.Client;
import com.example.coursemanagementapp.transformer.ClientTransformer;
import jakarta.persistence.EntityNotFoundException;
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
    private final ReferralSourceService referralSourceService;
    private final HistoryService historyService;

    @Override
    public ClientDao getDao() {
        return clientDao;
    }

    @Override
    public ClientTransformer getTransformer() {
        return clientTransformer;
    }

    @Override
    public String getEntityName() {
        return Client.class.getSimpleName();
    }

    @Override
    public PaginationResponse<ClientDto> findAllPaginatedAndFiltered(PaginationRequest<ClientSearchDto> paginationRequest) {
        log.info("ClientService: findAllPaginatedAndFiltered() - was called with paginationRequest: {}", paginationRequest);
        return buildPaginationResponse(getDao().findAllPaginatedAndFiltered(paginationRequest));
    }

    @Transactional
    @Override
    public void updateName(Long id, ClientDto clientDto) {
        log.info("ClientService: updateName() - was called with id: {} and clientDto: {}", id, clientDto);
        ClientDto clientDtoDb = findById(id);
        historyService.create(HistoryDto.HistoryDtoBuilder()
                .entityId(id)
                .entityType(getEntityName())
                .fieldName("name")
                .oldValue(clientDtoDb.getName())
                .newValue(clientDto.getName())
                .build());
        getDao().updateName(id, clientDto.getName());
    }

    @Transactional
    @Override
    public void updateStatus(Long id, Long statusId) {
        log.info("ClientService: updateStatus() - was called with id: {} and statusId: {}", id, statusId);
        ClientDto clientDto = findById(id);
        if (!clientStatusService.existsById(statusId))
            throw new EntityNotFoundException("Status with id " + statusId + " does not exist");
        historyService.create(HistoryDto.HistoryDtoBuilder()
                .entityId(id)
                .entityType(getEntityName())
                .fieldName("clientStatus")
                .oldValue(clientDto.getClientStatus() == null ? "" : clientDto.getClientStatus().getStatus().getStatus())
                .newValue(clientStatusService.findById(statusId).getStatus().getStatus())
                .build());
        getDao().updateStatus(id, statusId);
    }

    @Transactional
    @Override
    public void updateDescription(Long id, ClientDto clientDto) {
        log.info("ClientService: updateDescription() - was called with id: {} and clientDto: {}", id, clientDto);
        ClientDto clientDtoDb = findById(id);
        historyService.create(HistoryDto.HistoryDtoBuilder()
                .entityId(id)
                .entityType(getEntityName())
                .fieldName("description")
                .oldValue(clientDtoDb.getDescription())
                .newValue(clientDto.getDescription())
                .build());
        getDao().updateDescription(id, clientDto.getDescription());
    }

    @Transactional
    @Override
    public void updateEmail(Long id, ClientDto clientDto) {
        log.info("ClientService: updateEmail() - was called with id: {} and clientDto: {}", id, clientDto);
        ClientDto clientDtoDb = findById(id);
        historyService.create(HistoryDto.HistoryDtoBuilder()
                .entityId(id)
                .entityType(getEntityName())
                .fieldName("email")
                .oldValue(clientDtoDb.getEmail())
                .newValue(clientDto.getEmail())
                .build());
        getDao().updateEmail(id, clientDto.getEmail());
    }

    @Transactional
    @Override
    public void updatePhone(Long id, ClientDto clientDto) {
        log.info("ClientService: updatePhone() - was called with id: {} and clientDto: {}", id, clientDto);
        ClientDto clientDtoDb = findById(id);
        historyService.create(HistoryDto.HistoryDtoBuilder()
                .entityId(id)
                .entityType(getEntityName())
                .fieldName("phone")
                .oldValue(clientDtoDb.getPhone())
                .newValue(clientDto.getPhone())
                .build());
        getDao().updatePhone(id, clientDto.getPhone());
    }

    @Transactional
    @Override
    public void updateAlternativePhone(Long id, ClientDto clientDto) {
        log.info("ClientService: updateAlternativePhone() - was called with id: {} and clientDto: {}", id, clientDto);
        ClientDto clientDtoDb = findById(id);
        historyService.create(HistoryDto.HistoryDtoBuilder()
                .entityId(id)
                .entityType(getEntityName())
                .fieldName("alternativePhone")
                .oldValue(clientDtoDb.getAlternativePhone())
                .newValue(clientDto.getAlternativePhone())
                .build());
        getDao().updateAlternativePhone(id, clientDto.getAlternativePhone());
    }

    @Transactional
    @Override
    public void updateCountry(Long id, ClientDto clientDto) {
        log.info("ClientService: updateCountry() - was called with id: {} and clientDto: {}", id, clientDto);
        ClientDto clientDtoDb = findById(id);
        historyService.create(HistoryDto.HistoryDtoBuilder()
                .entityId(id)
                .entityType(getEntityName())
                .fieldName("country")
                .oldValue(clientDtoDb.getCountry())
                .newValue(clientDto.getCountry())
                .build());
        getDao().updateCountry(id, clientDto.getCountry());
    }

    @Transactional
    @Override
    public void updateNationality(Long id, ClientDto clientDto) {
        log.info("ClientService: updateNationality() - was called with id: {} and clientDto: {}", id, clientDto);
        ClientDto clientDtoDb = findById(id);
        historyService.create(HistoryDto.HistoryDtoBuilder()
                .entityId(id)
                .entityType(getEntityName())
                .fieldName("nationality")
                .oldValue(clientDtoDb.getNationality())
                .newValue(clientDto.getNationality())
                .build());
        getDao().updateNationality(id, clientDto.getNationality());
    }

    @Transactional
    @Override
    public void updateAddress(Long id, ClientDto clientDto) {
        log.info("ClientService: updateAddress() - was called with id: {} and clientDto: {}", id, clientDto);
        ClientDto clientDtoDb = findById(id);
        historyService.create(HistoryDto.HistoryDtoBuilder()
                .entityId(id)
                .entityType(getEntityName())
                .fieldName("address")
                .oldValue(clientDtoDb.getAddress())
                .newValue(clientDto.getAddress())
                .build());
        getDao().updateAddress(id, clientDto.getAddress());
    }

    @Transactional
    @Override
    public void updateSpecialty(Long id, ClientDto clientDto) {
        log.info("ClientService: updateSpecialty() - was called with id: {} and clientDto: {}", id, clientDto);
        ClientDto clientDtoDb = findById(id);
        historyService.create(HistoryDto.HistoryDtoBuilder()
                .entityId(id)
                .entityType(getEntityName())
                .fieldName("specialty")
                .oldValue(clientDtoDb.getSpecialty())
                .newValue(clientDto.getSpecialty())
                .build());
        getDao().updateSpecialty(id, clientDto.getSpecialty());
    }

    @Transactional
    @Override
    public void updateReferralSource(Long id, Long referralSourceId) {
        log.info("ClientService: updateReferralSource() - was called with id: {} and referralSourceId: {}", id, referralSourceId);
        ClientDto clientDto = findById(id);
        if (!referralSourceService.existsById(referralSourceId))
            throw new EntityNotFoundException("Referral Source with id " + referralSourceId + " does not exist");
        historyService.create(HistoryDto.HistoryDtoBuilder()
                .entityId(id)
                .entityType(getEntityName())
                .fieldName("referralSource")
                .oldValue(clientDto.getReferralSource() == null ? "" : clientDto.getReferralSource().getSource().getSource())
                .newValue(referralSourceService.findById(referralSourceId).getSource().getSource())
                .build());
        getDao().updateReferralSource(id, referralSourceId);
    }

}
