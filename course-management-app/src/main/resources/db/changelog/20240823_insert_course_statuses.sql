--liquibase formatted sql
--changeset sayed:20240823_insert_course_statuses
INSERT INTO public.course_status (id, status, created_date, modified_date, created_by, modified_by, marked_as_deleted)
VALUES (nextval('course_status_id_sequence'), 'STARTED', current_timestamp, current_timestamp, 'system', 'system',
        false),
       (nextval('course_status_id_sequence'), 'NOT_STARTED', current_timestamp, current_timestamp, 'system', 'system',
        false);