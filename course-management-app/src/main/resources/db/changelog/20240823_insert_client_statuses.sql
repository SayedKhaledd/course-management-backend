--liquibase formatted sql
--changeset sayed:20240823_insert_client_statuses
INSERT INTO public.client_status (id, status, created_date, modified_date, created_by, modified_by, marked_as_deleted)
VALUES (nextval('client_status_id_sequence'), 'INTERESTED', current_timestamp, current_timestamp, 'system', 'system',
        false),
       (nextval('client_status_id_sequence'), 'NOT_INTERESTED', current_timestamp, current_timestamp, 'system', 'system',
        false),
       (nextval('client_status_id_sequence'), 'NEEDS_MORE_INFO', current_timestamp, current_timestamp, 'system', 'system',
        false);