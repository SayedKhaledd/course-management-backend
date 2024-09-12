package com.example.coursemanagementapp.dao.repo;

import com.example.coursemanagementapp.dto.ClientSearchDto;
import com.example.coursemanagementapp.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends JpaRepository<Client, Long> {

    Page<Client> findAllByMarkedAsDeleted(Pageable pageable, Boolean markedAsDeleted);

    @Query("""
            SELECT c
            FROM Client c
            WHERE
                ( :#{#clientSearchDto.name} IS NULL OR c.name LIKE %:#{#clientSearchDto.name}%)
                AND ( :#{#clientSearchDto.email} IS NULL OR c.email LIKE %:#{#clientSearchDto.email}%)
                AND ( :#{#clientSearchDto.phone} IS NULL OR c.phone LIKE %:#{#clientSearchDto.phone}%)
                AND ( :#{#clientSearchDto.specialty} IS NULL OR c.specialty LIKE %:#{#clientSearchDto.specialty}%)
                AND ( (:#{#clientSearchDto.countries}) IS NULL OR c.country IN (:#{#clientSearchDto.countries}))
                AND ( (:#{#clientSearchDto.nationalities}) IS NULL OR c.nationality IN (:#{#clientSearchDto.nationalities}))
                AND ( (:#{#clientSearchDto.clientStatusIds}) IS NULL OR c.clientStatusId IN (:#{#clientSearchDto.clientStatusIds}))
                AND ( (:#{#clientSearchDto.referralSourceIds}) IS NULL OR c.referralSourceId IN (:#{#clientSearchDto.referralSourceIds}))
                AND c.markedAsDeleted = :markedAsDeleted
            """)
    Page<Client> findAllFilteredAndPaginated(Pageable pageable, ClientSearchDto clientSearchDto, Boolean markedAsDeleted);

}
