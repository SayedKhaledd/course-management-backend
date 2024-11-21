package com.example.coursemanagementapp.dao;

import com.example.backendcoreservice.api.pagination.PaginationRequest;
import com.example.backendcoreservice.dao.EntityManagerDao;
import com.example.coursemanagementapp.config.AuditAwareImpl;
import com.example.coursemanagementapp.dao.repo.ClientRepo;
import com.example.coursemanagementapp.dto.search.ClientSearchDto;
import com.example.coursemanagementapp.model.Client;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class ClientDaoImpl implements ClientDao {

    private final ClientRepo clientRepo;
    @Qualifier("auditAwareImpl")
    private final AuditAwareImpl auditAware;

    private final EntityManagerDao entityManagerDao;

    @Override
    public ClientRepo getRepo() {
        return clientRepo;
    }

    @Override
    public Page<Client> findAllPaginatedAndFiltered(PaginationRequest<ClientSearchDto> paginationRequest) {
        log.info("ClientDao: findAllPaginatedAndFiltered() - was called");
        ClientSearchDto criteria = paginationRequest.getCriteria();
        if (criteria == null)
            return getRepo().findAll(getPageRequest(paginationRequest));

        return getRepo().findAllFilteredAndPaginated(getPageRequest(paginationRequest), criteria);
    }

    @Override
    public void updateName(Long id, String name) {
        log.info("ClientDao: updateName() - was called");
        entityManagerDao.updateQuery(Client.class.getSimpleName(), id, "name", name, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updateStatus(Long id, Long statusId) {
        log.info("ClientDao: updateStatus() - was called");
        entityManagerDao.updateQuery(Client.class.getSimpleName(), id, "clientStatusId", statusId, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updateDescription(Long id, String description) {
        log.info("ClientDao: updateDescription() - was called");
        entityManagerDao.updateQuery(Client.class.getSimpleName(), id, "description", description, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updateEmail(Long id, String email) {
        log.info("ClientDao: updateEmail() - was called");
        entityManagerDao.updateQuery(Client.class.getSimpleName(), id, "email", email, auditAware.getCurrentAuditor().get(), LocalDateTime.now());

    }

    @Override
    public void updatePhone(Long id, String phone) {
        log.info("ClientDao: updatePhone() - was called");
        entityManagerDao.updateQuery(Client.class.getSimpleName(), id, "phone", phone, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updateAlternativePhone(Long id, String alternativePhone) {
        log.info("ClientDao: updateAlternativePhone() - was called");
        entityManagerDao.updateQuery(Client.class.getSimpleName(), id, "alternativePhone", alternativePhone, auditAware.getCurrentAuditor().get(), LocalDateTime.now());

    }

    @Override
    public void updateCountry(Long id, String country) {
        log.info("ClientDao: updateCountry() - was called");
        entityManagerDao.updateQuery(Client.class.getSimpleName(), id, "country", country, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updateNationality(Long id, String nationality) {
        log.info("ClientDao: updateNationality() - was called");
        entityManagerDao.updateQuery(Client.class.getSimpleName(), id, "nationality", nationality, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updateAddress(Long id, String address) {
        log.info("ClientDao: updateAddress() - was called");
        entityManagerDao.updateQuery(Client.class.getSimpleName(), id, "address", address, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updateSpecialty(Long id, String specialty) {
        log.info("ClientDao: updateSpecialty() - was called");
        entityManagerDao.updateQuery(Client.class.getSimpleName(), id, "specialty", specialty, auditAware.getCurrentAuditor().get(), LocalDateTime.now());

    }

    @Override
    public void updateReferralSource(Long id, Long referralSourceId) {
        log.info("ClientDao: updateReferralSource() - was called");
        entityManagerDao.updateQuery(Client.class.getSimpleName(), id, "referralSourceId", referralSourceId, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updateInitialCourse(Long id, Long initialCourseId) {
        log.info("ClientDao: updateInitialCourse() - was called");
        entityManagerDao.updateQuery(Client.class.getSimpleName(), id, "initialCourseId", initialCourseId, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }
}
