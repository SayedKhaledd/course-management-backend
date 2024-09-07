--liquibase formatted sql
--changeset sayed:20240823_insert_evaluation_statuses
INSERT INTO public.evaluation_status (id, status, created_date, modified_date, created_by, modified_by,
                                      marked_as_deleted)
VALUES (nextval('evaluation_status_id_sequence'), 'PASSED', current_timestamp, current_timestamp, 'system', 'system',
        false),
       (nextval('evaluation_status_id_sequence'), 'FAILED', current_timestamp, current_timestamp, 'system', 'system',
        false),
       (nextval('evaluation_status_id_sequence'), 'NOT_AVAILABLE', current_timestamp, current_timestamp, 'system',
        'system', false);