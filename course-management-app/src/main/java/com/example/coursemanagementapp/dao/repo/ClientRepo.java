package com.example.coursemanagementapp.dao.repo;

import com.example.coursemanagementapp.dto.search.ClientSearchDto;
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

    @Query("""
                 SELECT c
                 FROM Client c
                 WHERE
                     (:#{#clientSearchDto.name} IS NULL OR c.name LIKE CONCAT('%', :#{#clientSearchDto.name}, '%'))
                     AND (:#{#clientSearchDto.email} IS NULL OR c.email LIKE CONCAT('%', :#{#clientSearchDto.email}, '%'))
                     AND (:#{#clientSearchDto.phone} IS NULL OR c.phone LIKE CONCAT('%', :#{#clientSearchDto.phone}, '%'))
                     AND (:#{#clientSearchDto.alternativePhone} IS NULL OR c.alternativePhone LIKE CONCAT('%', :#{#clientSearchDto.alternativePhone}, '%'))
                     AND (:#{#clientSearchDto.address} IS NULL OR c.address LIKE CONCAT('%', :#{#clientSearchDto.address}, '%'))
                     AND (:#{#clientSearchDto.description} IS NULL OR c.description LIKE CONCAT('%', :#{#clientSearchDto.description}, '%'))
                     AND (:#{#clientSearchDto.specialty} IS NULL OR c.specialty LIKE CONCAT('%', :#{#clientSearchDto.specialty}, '%'))
                     AND (:#{#clientSearchDto.countries} IS NULL OR c.country IN :#{#clientSearchDto.countries})
                     AND (:#{#clientSearchDto.nationalities} IS NULL OR c.nationality IN :#{#clientSearchDto.nationalities})
                     AND (:#{#clientSearchDto.clientStatusIds} IS NULL OR c.clientStatusId IN :#{#clientSearchDto.clientStatusIds})
                     AND (:#{#clientSearchDto.referralSourceIds} IS NULL OR c.referralSourceId IN :#{#clientSearchDto.referralSourceIds})
                     AND (:#{#clientSearchDto.initialCourseIds} IS NULL OR c.initialCourseId IN :#{#clientSearchDto.initialCourseIds})
                     AND (:#{#clientSearchDto.createdBy} IS NULL OR c.createdBy LIKE CONCAT('%', :#{#clientSearchDto.createdBy}, '%'))
                     AND (:#{#clientSearchDto.modifiedBy} IS NULL OR c.modifiedBy LIKE CONCAT('%', :#{#clientSearchDto.modifiedBy}, '%'))
                     AND (:#{#clientSearchDto.createdDate} IS NULL OR CAST(c.createdDate AS string) LIKE CONCAT('%', :#{#clientSearchDto.createdDate}, '%'))
                     AND (:#{#clientSearchDto.modifiedDate} IS NULL OR CAST(c.modifiedDate AS string) LIKE CONCAT('%', :#{#clientSearchDto.modifiedDate}, '%'))
            """)
    Page<Client> findAllFilteredAndPaginated(Pageable pageable, ClientSearchDto clientSearchDto);

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


    @Modifying
    @Query(value = "UPDATE client SET initial_course_id = :initialCourseId WHERE id = :id AND marked_as_deleted = false", nativeQuery = true)
    void updateInitialCourse(Long id, Long initialCourseId);
}
