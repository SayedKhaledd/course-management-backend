package com.example.coursemanagementapp.dao;

import com.example.backendcoreservice.api.pagination.PaginationRequest;
import com.example.coursemanagementapp.dao.repo.ClientRepo;
import com.example.coursemanagementapp.dto.ClientSearchDto;
import com.example.coursemanagementapp.model.Client;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
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
        Boolean markedAsDeleted = paginationRequest.getDeletedRecords();
        if (criteria == null)
            return getRepo().findAllByMarkedAsDeleted(getPageRequest(paginationRequest), markedAsDeleted);

        return getRepo().findAllFilteredAndPaginated(getPageRequest(paginationRequest), criteria, markedAsDeleted);
    }

    @Override
    public void updateStatus(Long id, Long statusId) {
        log.info("ClientDao: updateStatus() - was called");
        getRepo().updateStatus(id, statusId);
    }

    @Override
    public void updateDescription(Long id, String description) {
        log.info("ClientDao: updateDescription() - was called");
        getRepo().updateDescription(id, description);
    }

    @Override
    public void updateEmail(Long id, String email) {
        log.info("ClientDao: updateEmail() - was called");
        getRepo().updateEmail(id, email);
    }

    @Override
    public void updatePhone(Long id, String phone) {
        log.info("ClientDao: updatePhone() - was called");
        getRepo().updatePhone(id, phone);
    }

    @Override
    public void updateAlternativePhone(Long id, String alternativePhone) {
        log.info("ClientDao: updateAlternativePhone() - was called");
        getRepo().updateAlternativePhone(id, alternativePhone);
    }

    @Override
    public void updateCountry(Long id, String country) {
        log.info("ClientDao: updateCountry() - was called");
        getRepo().updateCountry(id, country);
    }

    @Override
    public void updateNationality(Long id, String nationality) {
        log.info("ClientDao: updateNationality() - was called");
        getRepo().updateNationality(id, nationality);
    }

    @Override
    public void updateAddress(Long id, String address) {
        log.info("ClientDao: updateAddress() - was called");
        getRepo().updateAddress(id, address);
    }

    @Override
    public void updateSpecialty(Long id, String specialty) {
        log.info("ClientDao: updateSpecialty() - was called");
        getRepo().updateSpecialty(id, specialty);
    }

    @Override
    public void updateReferralSource(Long id, Long referralSourceId) {
        log.info("ClientDao: updateReferralSource() - was called");
        getRepo().updateReferralSource(id, referralSourceId);
    }
}
