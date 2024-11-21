--liquibase formatted sql
--changeset sayed:20241118_sales_view
CREATE OR REPLACE VIEW public.sales_view AS
SELECT e.id                AS entity_id,
       c.id                AS client_id,
       co.id               AS course_id,
       e.amount_paid       AS amount,
       'COURSE_PURCHASE'   AS type,
       pm.id               AS payment_method_id,
       ps.id               AS payment_status_id,
       e.currency          AS currency,
       e.is_received       AS is_received,
       e.marked_as_deleted AS marked_as_deleted,
       e.created_date      AS created_date,
       e.modified_date     AS modified_date,
       e.created_by        AS created_by,
       e.modified_by       AS modified_by
FROM enrollment e
         JOIN client c ON e.client_id = c.id
         JOIN course co ON e.course_id = co.id
         LEFT JOIN payment_method pm ON e.payment_method_id = pm.id
         JOIN payment_status ps ON e.payment_status_id = ps.id
WHERE c.marked_as_deleted = FALSE
  and co.marked_as_deleted = FALSE
  and (pm is null or pm.marked_as_deleted = FALSE)
  and ps.marked_as_deleted = FALSE
  and e.marked_as_deleted = FALSE

UNION

SELECT i.id                AS entity_id,
       c.id                AS client_id,
       co.id               AS course_id,
       i.amount            AS amount,
       'INSTALLMENT'       AS type,
       pm.id               AS payment_method_id,
       ps.id               AS payment_status_id,
       i.currency          AS currency,
       i.is_received       AS is_received,
       i.marked_as_deleted AS marked_as_deleted,
       i.created_date      AS created_date,
       i.modified_date     AS modified_date,
       i.created_by        AS created_by,
       i.modified_by       AS modified_by
FROM installment i
         JOIN enrollment e ON i.enrollment_id = e.id
         JOIN client c ON e.client_id = c.id
         JOIN course co ON e.course_id = co.id
         LEFT JOIN payment_method pm ON i.payment_method_id = pm.id
         JOIN payment_status ps ON i.payment_status_id = ps.id
WHERE c.marked_as_deleted = FALSE
  and co.marked_as_deleted = FALSE
  and (pm is null or pm.marked_as_deleted = FALSE)
  and ps.marked_as_deleted = FALSE
  and i.marked_as_deleted = FALSE

UNION

SELECT r.id                   AS entity_id,
       c.id                   AS client_id,
       co.id                  AS course_id,
       r.refunded_amount * -1 AS amount,
       'REFUND'               AS type,
       rm.id                  AS payment_method_id,
       rs.id                  AS payment_status_id,
       r.currency             AS currency,
       r.is_received          AS is_received,
       r.marked_as_deleted    AS marked_as_deleted,
       r.created_date         AS created_date,
       r.modified_date        AS modified_date,
       r.created_by           AS created_by,
       r.modified_by          AS modified_by
FROM refund r
         JOIN enrollment e ON r.enrollment_id = e.id
         JOIN client c ON e.client_id = c.id
         JOIN course co ON e.course_id = co.id
         LEFT JOIN refund_method rm ON r.refund_method_id = rm.id
         JOIN refund_status rs ON r.refund_status_id = rs.id
WHERE c.marked_as_deleted = FALSE
  and co.marked_as_deleted = FALSE
  and (rm is null or rm.marked_as_deleted = FALSE)
  and r.marked_as_deleted = FALSE;