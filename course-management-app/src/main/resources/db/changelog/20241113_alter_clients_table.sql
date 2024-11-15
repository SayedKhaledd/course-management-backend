--liquibase formatted sql
--changeset sayed:20241113_alter_client_table_add_column_initial_course_id
ALTER TABLE public.client
    ADD COLUMN initial_course_id BIGINT;
ALTER TABLE public.client
    ADD CONSTRAINT client_initial_course_id_fk FOREIGN KEY (initial_course_id) REFERENCES public.course (id);
--changeset sayed:20241113_client_table_insert_initial_course_id
UPDATE public.client c
SET initial_course_id = (SELECT id
                         FROM public.course
                         WHERE code = 'N/A'
                           AND part = '1'
                           AND name = c.initial_course_name
                           AND marked_as_deleted = false)
WHERE initial_course_name IS NOT NULL
  AND initial_course_name != ''
  AND marked_as_deleted = false;

--changeset sayed:20241113_alter_client_table_drop_column_initial_course_name
ALTER TABLE public.client
    DROP COLUMN initial_course_name;