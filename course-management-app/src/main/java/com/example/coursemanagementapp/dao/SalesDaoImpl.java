package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.dto.SalesDto;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Component
public class SalesDaoImpl implements SalesDao {
    private final EntityManager entityManager;

    @Override
    public List<SalesDto> findAll() {
        String query = """
                           SELECT c.name         as clientName,
                       co.name        as courseName,
                       e.amount_paid  AS amount,
                       'Enrollment'   AS type,
                       pm.method      AS paymentMethod,
                       e.created_date AS saleDate,
                       e.currency     AS currency
                FROM enrollment e
                         JOIN client c ON e.client_id = c.id
                         JOIN course co ON e.course_id = co.id
                         JOIN payment_method pm ON e.payment_method_id = pm.id
                         JOIN payment_status ps ON e.payment_status_id = ps.id
                WHERE ps.status = 'PAID'
                  and c.marked_as_deleted = FALSE
                  and co.marked_as_deleted = FALSE
                  and pm.marked_as_deleted = FALSE
                  and ps.marked_as_deleted = FALSE
                  and e.marked_as_deleted = FALSE
                
                UNION
                
                SELECT c.name         AS clientName,
                       co.name        AS courseName,
                       i.amount       AS amount,
                       'Installment'  AS type,
                       pm.method      AS paymentMethod,
                       i.created_date AS saleDate,
                       i.currency     AS currency
                FROM installment i
                         JOIN enrollment e ON i.enrollment_id = e.id
                         JOIN client c ON e.client_id = c.id
                         JOIN course co ON e.course_id = co.id
                         JOIN payment_method pm ON i.payment_method_id = pm.id
                         JOIN payment_status ps ON i.payment_status_id = ps.id
                WHERE ps.status = 'PAID'
                  and c.marked_as_deleted = FALSE
                  and co.marked_as_deleted = FALSE
                  and pm.marked_as_deleted = FALSE
                  and ps.marked_as_deleted = FALSE
                  and i.marked_as_deleted = FALSE
                
                UNION
                
                SELECT c.name         AS clientName,
                       co.name        AS courseName,
                       r.amount * -1  AS amount,
                       'Refund'       AS type,
                       pm.method      AS paymentMethod,
                       r.created_date AS saleDate,
                       r.currency     AS currency
                FROM refund r
                         JOIN enrollment e ON r.enrollment_id = e.id
                         JOIN client c ON e.client_id = c.id
                         JOIN course co ON e.course_id = co.id
                         JOIN payment_method pm ON r.payment_method_id = pm.id
                         JOIN payment_status ps ON r.refund_status_id = ps.id
                WHERE ps.status = 'PAID'
                  AND r.is_confirmed = TRUE
                  and c.marked_as_deleted = FALSE
                  and co.marked_as_deleted = FALSE
                  and pm.marked_as_deleted = FALSE
                  and ps.marked_as_deleted = FALSE
                  and r.marked_as_deleted = FALSE
                ORDER BY saleDate DESC
                
                
                
                """;
        return (List<SalesDto>) entityManager.createNativeQuery(query).getResultList();
    }
}
