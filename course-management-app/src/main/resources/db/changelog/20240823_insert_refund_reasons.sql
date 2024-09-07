--liquibase formatted sql
--changeset sayed:20240823_insert_refund_reasons
INSERT INTO public.refund_reason (id, reason, created_date, modified_date, created_by, modified_by, marked_as_deleted)
VALUES (nextval('refund_reason_id_sequence'), 'DID_NOT_LIKE_THE_COURSE', current_timestamp, current_timestamp, 'system', 'system',
        false),
       (nextval('refund_reason_id_sequence'), 'DID_NOT_ATTEND_THE_COURSE', current_timestamp, current_timestamp, 'system', 'system',
        false),
       (nextval('refund_reason_id_sequence'), 'OTHER', current_timestamp, current_timestamp, 'system', 'system', false);