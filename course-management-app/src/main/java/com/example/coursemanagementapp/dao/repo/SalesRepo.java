package com.example.coursemanagementapp.dao.repo;

import com.example.coursemanagementapp.dto.search.SalesSearchDto;
import com.example.coursemanagementapp.model.Sales;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepo extends JpaRepository<Sales, Long> {

    @Query(""" 
            SELECT s FROM Sales s
             WHERE (:#{#criteria.clientId} IS NULL OR s.client.id = :#{#criteria.clientId})
             AND (:#{#criteria.courseCode} IS NULL OR s.course.code = :#{#criteria.courseCode})
             AND (:#{#criteria.paymentTypes} IS NULL OR s.type IN :#{#criteria.paymentTypes})
             AND (:#{#criteria.isReceived} IS NULL OR s.isReceived = :#{#criteria.isReceived})
             AND (:#{#criteria.paymentMethodIds} IS NULL OR s.paymentMethod.id IN :#{#criteria.paymentMethodIds})
             AND (:#{#criteria.paymentStatusIds} IS NULL OR  s.paymentStatusId IN :#{#criteria.paymentStatusIds} )
             AND (:#{#criteria.courseIds} IS NULL OR s.course.id IN :#{#criteria.courseIds})
             AND (:#{#criteria.currencies} IS NULL OR s.currency IN :#{#criteria.currencies})
             AND (:#{#criteria.createdBy} IS NULL OR s.createdBy = :#{#criteria.createdBy})
             AND (:#{#criteria.modifiedBy} IS NULL OR s.modifiedBy = :#{#criteria.modifiedBy})
             AND (:#{#criteria.createdDate} IS NULL OR CAST(s.createdDate AS string)  LIKE CONCAT('%', (:#{#criteria.createdDate}), '%'))
             AND (:#{#criteria.modifiedDate} IS NULL OR CAST(s.modifiedDate AS string)  LIKE CONCAT('%', (:#{#criteria.modifiedDate} ), '%'))
            """)
    Page<Sales> findAllFilteredAndPaginated(Pageable pageRequest, SalesSearchDto criteria);
}
