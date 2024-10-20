--liquibase formatted sql
--changeset sayed:20241020_course_lecturer_history_table
CREATE SEQUENCE public.course_lecturer_history_id_sequence
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807 CACHE 1;

ALTER SEQUENCE public.course_lecturer_history_id_sequence
    OWNER TO ${user_owner};

CREATE TABLE public.course_lecturer_history
(
    id                BIGINT                 NOT NULL DEFAULT nextval('course_lecturer_history_id_sequence'),
    field_name        VARCHAR(255)           NOT NULL,
    old_value         VARCHAR(255),
    new_value         VARCHAR(255),
    course_lecturer_id         BIGINT                 NOT NULL,

    created_date      TIMESTAMP              NOT NULL,
    modified_date     TIMESTAMP              NOT NULL,
    created_by        CHARACTER VARYING(100) NOT NULL,
    modified_by       CHARACTER VARYING(100) NOT NULL,
    marked_as_deleted BOOLEAN                NOT NULL DEFAULT FALSE,
    CONSTRAINT course_lecturer_history_pk PRIMARY KEY (id),
    CONSTRAINT course_lecturer_history_enrollment_id_fk FOREIGN KEY (course_lecturer_id) REFERENCES public.course_lecturer (id)
) TABLESPACE pg_default;

ALTER TABLE public.course_lecturer_history
    OWNER TO ${user_owner};
