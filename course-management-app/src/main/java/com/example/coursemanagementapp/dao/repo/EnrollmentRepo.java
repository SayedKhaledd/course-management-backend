package com.example.coursemanagementapp.dao.repo;

import com.example.coursemanagementapp.dto.search.EnrollmentSearchDto;
import com.example.coursemanagementapp.model.Enrollment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EnrollmentRepo extends JpaRepository<Enrollment, Long> {

    List<Enrollment> findAllByClientId(Long clientId);

    List<Enrollment> findAllByCourseId(Long courseId);

    Enrollment findByClientIdAndCourseId(Long clientId, Long courseId);

    @Query("""
                SELECT e
                FROM Enrollment e
                WHERE
                    (:#{#enrollmentSearchDto.clientId} IS NULL OR e.client.id = :#{#enrollmentSearchDto.clientId})
                    AND (:#{#enrollmentSearchDto.courseId} IS NULL OR e.course.id = :#{#enrollmentSearchDto.courseId})
                    AND (:#{#enrollmentSearchDto.clientName} IS NULL OR e.client.name LIKE CONCAT('%', :#{#enrollmentSearchDto.clientName}, '%'))
                    AND (:#{#enrollmentSearchDto.courseName} IS NULL OR e.course.name LIKE CONCAT('%', :#{#enrollmentSearchDto.courseName}, '%'))
                    AND (:#{#enrollmentSearchDto.amountPaid} IS NULL OR e.amountPaid = :#{#enrollmentSearchDto.amountPaid})
                    AND (:#{#enrollmentSearchDto.remainingAmount} IS NULL OR e.remainingAmount = :#{#enrollmentSearchDto.remainingAmount})
                    AND (:#{#enrollmentSearchDto.totalAmount} IS NULL OR e.totalAmount = :#{#enrollmentSearchDto.totalAmount})
                    AND (:#{#enrollmentSearchDto.discount} IS NULL OR e.discount = :#{#enrollmentSearchDto.discount})
                    AND (:#{#enrollmentSearchDto.currencies} IS NULL OR e.currency IN :#{#enrollmentSearchDto.currencies})
                    AND (:#{#enrollmentSearchDto.payInInstallments} IS NULL OR e.payInInstallments IN :#{#enrollmentSearchDto.payInInstallments})
                    AND (:#{#enrollmentSearchDto.insideEgypt} IS NULL OR e.insideEgypt IN :#{#enrollmentSearchDto.insideEgypt})
                    AND (:#{#enrollmentSearchDto.review} IS NULL OR e.review LIKE CONCAT('%', :#{#enrollmentSearchDto.review}, '%'))
                    AND (:#{#enrollmentSearchDto.ratings} IS NULL OR e.rating IN :#{#enrollmentSearchDto.ratings})
                    AND (:#{#enrollmentSearchDto.description} IS NULL OR e.description LIKE CONCAT('%', :#{#enrollmentSearchDto.description}, '%'))
                    AND (:#{#enrollmentSearchDto.paymentStatusIds} IS NULL OR e.paymentStatusId IN :#{#enrollmentSearchDto.paymentStatusIds})
                    AND (:#{#enrollmentSearchDto.paymentMethodIds} IS NULL OR e.paymentMethodId IN :#{#enrollmentSearchDto.paymentMethodIds})
                    AND (:#{#enrollmentSearchDto.actionTakenIds} IS NULL OR e.actionTakenId IN :#{#enrollmentSearchDto.actionTakenIds})
                    AND (:#{#enrollmentSearchDto.referralSourceIds} IS NULL OR e.referralSourceId IN :#{#enrollmentSearchDto.referralSourceIds})
                    AND (:#{#enrollmentSearchDto.createdBy} IS NULL OR e.createdBy LIKE CONCAT('%', :#{#enrollmentSearchDto.createdBy}, '%'))
                    AND (:#{#enrollmentSearchDto.modifiedBy} IS NULL OR e.modifiedBy LIKE CONCAT('%', :#{#enrollmentSearchDto.modifiedBy}, '%'))
                    AND (:#{#enrollmentSearchDto.createdDate} IS NULL OR CAST(e.createdDate AS string) LIKE CONCAT('%', :#{#enrollmentSearchDto.createdDate}, '%'))
                    AND (:#{#enrollmentSearchDto.modifiedDate} IS NULL OR CAST(e.modifiedDate AS string) LIKE CONCAT('%', :#{#enrollmentSearchDto.modifiedDate}, '%'))     
            """)
    Page<Enrollment> findAllFilteredAndPaginated(Pageable pageable, EnrollmentSearchDto enrollmentSearchDto);


}
