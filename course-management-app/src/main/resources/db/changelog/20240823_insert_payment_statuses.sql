--liquibase formatted sql
--changeset sayed:20240823_insert_payment_statuses

INSERT INTO public.payment_status (id, status, created_date, modified_date, created_by, modified_by, marked_as_deleted)
VALUES (nextval('payment_status_id_sequence'), 'PAID', current_timestamp, current_timestamp, 'system', 'system', false),
       (nextval('payment_status_id_sequence'), 'NOT_PAID', current_timestamp, current_timestamp, 'system', 'system',
        false),
       (nextval('payment_status_id_sequence'), 'PENDING', current_timestamp, current_timestamp, 'system', 'system',
        false);