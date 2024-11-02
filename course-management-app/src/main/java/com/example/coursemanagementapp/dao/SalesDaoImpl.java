package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.dto.SalesDto;
import com.example.coursemanagementapp.transformer.SalesTransformer;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.query.NativeQuery;
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
                SELECT
                       e.id           as id,
                       c.name         as clientName,
                       co.name        as courseName,
                       co.code        as courseCode,
                       e.amount_paid  AS amount,
                       'COURSE_PURCHASE'   AS type,
                       pm.method      AS paymentMethod,
                       e.created_date AS saleDate,
                       e.currency     AS currency,
                       e.is_received  AS isReceived
                FROM enrollment e
                         JOIN client c ON e.client_id = c.id
                         JOIN course co ON e.course_id = co.id
                         JOIN payment_method pm ON e.payment_method_id = pm.id
                         JOIN payment_status ps ON e.payment_status_id = ps.id
                WHERE ps.status = 'Done'
                  and c.marked_as_deleted = FALSE
                  and co.marked_as_deleted = FALSE
                  and pm.marked_as_deleted = FALSE
                  and ps.marked_as_deleted = FALSE
                  and e.marked_as_deleted = FALSE
                
                UNION
                
                SELECT
                       i.id           AS id,
                       c.name         AS clientName,
                       co.name        AS courseName,
                       co.code        as courseCode,
                       i.amount       AS amount,
                       'INSTALLMENT'  AS type,
                       pm.method      AS paymentMethod,
                       i.created_date AS saleDate,
                       i.currency     AS currency,
                       i.is_received  AS isReceived
                FROM installment i
                         JOIN enrollment e ON i.enrollment_id = e.id
                         JOIN client c ON e.client_id = c.id
                         JOIN course co ON e.course_id = co.id
                         JOIN payment_method pm ON i.payment_method_id = pm.id
                         JOIN payment_status ps ON i.payment_status_id = ps.id
                WHERE ps.status = 'Done'
                  and c.marked_as_deleted = FALSE
                  and co.marked_as_deleted = FALSE
                  and pm.marked_as_deleted = FALSE
                  and ps.marked_as_deleted = FALSE
                  and i.marked_as_deleted = FALSE
                
                UNION
                
                SELECT 
                       r.id           AS id,
                       c.name         AS clientName,
                       co.name        AS courseName,
                       co.code        as courseCode,
                       r.refunded_amount * -1  AS amount,
                       'REFUND'       AS type,
                       rm.method      AS paymentMethod,
                       r.created_date AS saleDate,
                       r.currency     AS currency,
                       r.is_received  AS isReceived
                FROM refund r
                         JOIN enrollment e ON r.enrollment_id = e.id
                         JOIN client c ON e.client_id = c.id
                         JOIN course co ON e.course_id = co.id
                         JOIN refund_method rm ON r.refund_method_id = rm.id
                         JOIN refund_status rs ON r.refund_status_id = rs.id
                WHERE  rs.status = 'CONFIRMED'
                  and c.marked_as_deleted = FALSE
                  and co.marked_as_deleted = FALSE
                  and rm.marked_as_deleted = FALSE
                  and r.marked_as_deleted = FALSE
                ORDER BY saleDate DESC
                
                
                
                """;

        return (List<SalesDto>) entityManager.createNativeQuery(query)
                .unwrap(NativeQuery.class)
                .setResultTransformer(new SalesTransformer())
                .getResultList();
    }
}
