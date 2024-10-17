package com.example.coursemanagementapp.dao.repo;

import com.example.coursemanagementapp.dto.ClientSearchDto;
import com.example.coursemanagementapp.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

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

    @Modifying
    @Query(value = "UPDATE client SET name = :name WHERE id = :id AND marked_as_deleted = false", nativeQuery = true)
    void updateName(Long id, String name);

    @Modifying
    @Query(value = "UPDATE client SET status_id = :statusId WHERE id = :id AND marked_as_deleted = false", nativeQuery = true)
    void updateStatus(Long id, Long statusId);

    @Modifying
    @Query(value = "UPDATE client SET description = :description WHERE id = :id AND marked_as_deleted = false", nativeQuery = true)
    void updateDescription(Long id, String description);

    @Modifying
    @Query(value = "UPDATE client SET email = :email WHERE id = :id AND marked_as_deleted = false", nativeQuery = true)
    void updateEmail(Long id, String email);

    @Modifying
    @Query(value = "UPDATE client SET phone_number = :phone WHERE id = :id AND marked_as_deleted = false", nativeQuery = true)
    void updatePhone(Long id, String phone);

    @Modifying
    @Query(value = "UPDATE client SET alternative_phone_number = :alternativePhone WHERE id = :id AND marked_as_deleted = false", nativeQuery = true)
    void updateAlternativePhone(Long id, String alternativePhone);

    @Modifying
    @Query(value = "UPDATE client SET country = :country WHERE id = :id AND marked_as_deleted = false", nativeQuery = true)
    void updateCountry(Long id, String country);

    @Modifying
    @Query(value = "UPDATE client SET nationality = :nationality WHERE id = :id AND marked_as_deleted = false", nativeQuery = true)
    void updateNationality(Long id, String nationality);

    @Modifying
    @Query(value = "UPDATE client SET address = :address WHERE id = :id AND marked_as_deleted = false", nativeQuery = true)
    void updateAddress(Long id, String address);

    @Modifying
    @Query(value = "UPDATE client SET specialty = :specialty WHERE id = :id AND marked_as_deleted = false", nativeQuery = true)
    void updateSpecialty(Long id, String specialty);

    @Modifying
    @Query(value = "UPDATE client SET referral_source_id = :referralSourceId WHERE id = :id AND marked_as_deleted = false", nativeQuery = true)
    void updateReferralSource(Long id, Long referralSourceId);

    @Modifying
    @Query(value = "UPDATE client SET modified_date = :currentDate, modified_by = :modifiedBy WHERE id = :id AND marked_as_deleted = false", nativeQuery = true)
    void updateModifiedDateAndModifiedBy(Long id, String modifiedBy, LocalDateTime currentDate);


}
