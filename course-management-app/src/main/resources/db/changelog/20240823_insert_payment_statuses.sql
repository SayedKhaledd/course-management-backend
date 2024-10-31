--liquibase formatted sql
--changeset sayed:20240823_insert_payment_statuses

INSERT INTO public.payment_status (id, status, created_date, modified_date, created_by, modified_by, marked_as_deleted)
VALUES (nextval('payment_status_id_sequence'), 'Done', current_timestamp, current_timestamp, 'system', 'system', false),
       (nextval('payment_status_id_sequence'), 'waiting', current_timestamp, current_timestamp, 'system', 'system',
        false),
       (nextval('payment_status_id_sequence'), 'Canceled', current_timestamp, current_timestamp, 'system', 'system',
        false);