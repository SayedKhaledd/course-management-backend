package com.example.coursemanagementapp.dao;

import com.example.backendcoreservice.api.pagination.PaginationRequest;
import com.example.backendcoreservice.dao.AbstractDao;
import com.example.coursemanagementapp.dao.repo.ClientRepo;
import com.example.coursemanagementapp.dto.ClientSearchDto;
import com.example.coursemanagementapp.model.Client;
import org.springframework.data.domain.Page;

public interface ClientDao extends AbstractDao<Client, ClientRepo> {

    Page<Client> findAllPaginatedAndFiltered(PaginationRequest<ClientSearchDto> paginationRequest);

    void updateName(Long id, String name);

    void updateStatus(Long id, Long statusId);

    void updateDescription(Long id, String description);

    void updateEmail(Long id, String email);

    void updatePhone(Long id, String phone);

    void updateAlternativePhone(Long id, String alternativePhone);

    void updateCountry(Long id, String country);

    void updateNationality(Long id, String nationality);

    void updateAddress(Long id, String address);

    void updateSpecialty(Long id, String specialty);

    void updateReferralSource(Long id, Long referralSourceId);

    void updateInitialCourseName(Long id, String initialCourseName);
}
