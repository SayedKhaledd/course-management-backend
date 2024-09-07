--liquibase formatted sql
--changeset sayed:20240823_insert_action_taken
INSERT INTO public.action_taken (id, action, created_date, modified_date, created_by, modified_by, marked_as_deleted)
VALUES (nextval('action_taken_id_sequence'), 'ENROLLED', current_timestamp, current_timestamp, 'system', 'system',
        false),
       (nextval('action_taken_id_sequence'), 'DID_NOT_ENROL', current_timestamp, current_timestamp, 'system', 'system',
        false),
       (nextval('action_taken_id_sequence'), 'CANCELLED', current_timestamp, current_timestamp, 'system', 'system',
        false);