--liquibase formatted sql
--changeset sayed:20240804_course_table
CREATE SEQUENCE public.course_id_sequence
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807 CACHE 1;

ALTER SEQUENCE public.course_id_sequence
    OWNER TO ${user_owner};

CREATE TABLE public.course
(
    id                BIGINT                 NOT NULL DEFAULT nextval('course_id_sequence'),
    code              VARCHAR(255)           NOT NULL,
    part              VARCHAR(255)           NOT NULL,
    name              VARCHAR(255)           NOT NULL,
    description       TEXT,
    status_id         BIGINT                 NOT NULL,
    start_date        DATE,
    end_date          DATE,
    price             DECIMAL(10, 2)         NOT NULL,


    created_date      TIMESTAMP              NOT NULL,
    modified_date     TIMESTAMP              NOT NULL,
    created_by        CHARACTER VARYING(100) NOT NULL,
    modified_by       CHARACTER VARYING(100) NOT NULL,
    marked_as_deleted BOOLEAN                NOT NULL DEFAULT FALSE,
    CONSTRAINT course_pk PRIMARY KEY (id),
    CONSTRAINT course_status_fk FOREIGN KEY (status_id) REFERENCES course_status (id)

) TABLESPACE pg_default;

ALTER TABLE public.course
    OWNER TO ${user_owner};

CREATE UNIQUE INDEX course_code_uq
    ON public.course (code)
    WHERE marked_as_deleted = false;
--changeset sayed:20241113_alter_course_table_drop_unique_index
DROP INDEX course_code_uq;
--changeset sayed:20241113_alter_course_table_add_unique_index
CREATE UNIQUE INDEX course_code_uq
    ON public.course (code)
    WHERE marked_as_deleted = false AND code != 'N/A';
--changeset sayed:20250401_alter_course_table_add_number_of_participants_column
ALTER TABLE public.course
    ADD COLUMN number_of_participants INT;
--changeset sayed:20250401_alter_course_table_update_number_of_participants_column
UPDATE public.course
SET number_of_participants = (SELECT COUNT(*)
                              FROM public.enrollment
                              WHERE course_id = public.course.id
                                AND marked_as_deleted = false
                                AND action_taken_id = (SELECT id
                                                       FROM public.action_taken
                                                       WHERE action = 'ENROLLED'
                                                       LIMIT 1))
WHERE marked_as_deleted = false;
--changeset sayed:20250401_alter_course_table_remove_part_column
ALTER TABLE public.course
    DROP COLUMN part;