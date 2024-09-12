package com.example.coursemanagementapp.dao.repo;

import com.example.coursemanagementapp.dto.ClientSearchDto;
import com.example.coursemanagementapp.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends JpaRepository<Client, Long>, JpaSpecificationExecutor<Client> {

    @Query(value = "SELECT * FROM client c WHERE c.marked_as_deleted = :markedAsDeleted", nativeQuery = true)
    Page<Client> findAllByMarkedAsDeleted(Pageable pageable, Boolean markedAsDeleted);

    @Query(value = """
            SELECT c.*
            FROM client c
            WHERE
                ( COALESCE(:#{#clientSearchDto.name}, '') = '' OR c.name LIKE '%' || :#{#clientSearchDto.name} || '%')
                AND ( COALESCE(:#{#clientSearchDto.email}, '') = '' OR c.email LIKE '%' || :#{#clientSearchDto.email} || '%')
                AND ( COALESCE(:#{#clientSearchDto.phone}, '') = '' OR c.phone_number LIKE '%' || :#{#clientSearchDto.phone} || '%')
                AND ( COALESCE(:#{#clientSearchDto.specialty}, '') = '' OR c.specialty LIKE '%' || :#{#clientSearchDto.specialty} || '%')
                AND ( COALESCE(:#{#clientSearchDto.countries}, '') = '' OR c.country IN (:#{#clientSearchDto.countries}))
                AND ( COALESCE(:#{#clientSearchDto.nationalities}, '') = '' OR c.nationality IN (:#{#clientSearchDto.nationalities}))
                AND ( COALESCE(:#{#clientSearchDto.clientStatusIds}, '') = '' OR c.status_id IN (:#{#clientSearchDto.clientStatusIds}))
                AND ( COALESCE(:#{#clientSearchDto.referralSourceIds}, '') = '' OR c.referral_source_id IN (:#{#clientSearchDto.referralSourceIds}))
             AND c.marked_as_deleted = :markedAsDeleted
            """, nativeQuery = true)
    Page<Client> findAllFilteredAndPaginated(Pageable pageable, ClientSearchDto clientSearchDto, Boolean markedAsDeleted);

}
