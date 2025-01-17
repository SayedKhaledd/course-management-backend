--liquibase formatted sql
--changeset sayed:20240823_insert_refund_reasons
INSERT INTO public.refund_status (id, status, created_date, modified_date, created_by, modified_by, marked_as_deleted)
VALUES (nextval('refund_status_id_sequence'), 'CONFIRMED', current_timestamp, current_timestamp, 'system', 'system',
        false),
       (nextval('refund_status_id_sequence'), 'Cancel refund', current_timestamp, current_timestamp, 'system', 'system',
        false),
       (nextval('refund_status_id_sequence'), 'waiting', current_timestamp, current_timestamp, 'system', 'system',
        false);
--changeset sayed:20240823_update_refund_status_ids,
UPDATE public.refund_status
SET id = 4
WHERE status = 'CONFIRMED';
UPDATE public.refund_status
SET id = 5
WHERE status = 'Cancel refund';
UPDATE public.refund_status
SET id = 6
WHERE status = 'waiting';