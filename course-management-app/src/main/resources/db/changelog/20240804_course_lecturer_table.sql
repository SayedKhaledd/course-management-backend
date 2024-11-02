--liquibase formatted sql
--changeset sayed:20240804_course_lecturer_table
CREATE SEQUENCE public.course_lecturer_id_sequence
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807 CACHE 1;

ALTER SEQUENCE public.course_lecturer_id_sequence
    OWNER TO ${user_owner};

CREATE TABLE public.course_lecturer
(
    id                    BIGINT                 NOT NULL DEFAULT nextval('course_lecturer_id_sequence'),
    name                  VARCHAR(255)           NOT NULL,
    course_id             BIGINT                 NOT NULL,
    paid_in_percentage    BOOLEAN                NOT NULL DEFAULT FALSE,
    no_of_lectures        INTEGER                NOT NULL,
    lecture_cost          DECIMAL                NOT NULL,
    total_fixed_cost      DECIMAL                NOT NULL,
    percentage            DECIMAL,
    total_percentage_cost DECIMAL,

    created_date          TIMESTAMP              NOT NULL,
    modified_date         TIMESTAMP              NOT NULL,
    created_by            CHARACTER VARYING(100) NOT NULL,
    modified_by           CHARACTER VARYING(100) NOT NULL,
    marked_as_deleted     BOOLEAN                NOT NULL DEFAULT FALSE,
    CONSTRAINT course_lecturer_pk PRIMARY KEY (id),
    CONSTRAINT course_lecturer_course_id_fk FOREIGN KEY (course_id) REFERENCES public.course (id)
) TABLESPACE pg_default;

ALTER TABLE public.course_lecturer
    OWNER TO ${user_owner};

CREATE UNIQUE INDEX course_lecturer_name_course_id_uq
    ON public.course_lecturer (name, course_id)
    WHERE marked_as_deleted = false;
