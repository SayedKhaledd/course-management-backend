--liquibase formatted sql
--changeset sayed:20240804_evaluation_table
CREATE SEQUENCE public.evaluation_id_sequence
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807 CACHE 1;

ALTER SEQUENCE public.evaluation_id_sequence
    OWNER TO ${user_owner};

CREATE TABLE public.evaluation
(
    id                BIGINT                 NOT NULL DEFAULT nextval('evaluation_id_sequence'),
    enrollment_id     BIGINT                 NOT NULL,
    exam_name         CHARACTER VARYING(100) NOT NULL,
    status            CHARACTER VARYING(100) NOT NULL,


    created_date      TIMESTAMP              NOT NULL,
    modified_date     TIMESTAMP              NOT NULL,
    created_by        CHARACTER VARYING(100) NOT NULL,
    modified_by       CHARACTER VARYING(100) NOT NULL,
    marked_as_deleted BOOLEAN                NOT NULL DEFAULT FALSE,
    CONSTRAINT evaluation_pk PRIMARY KEY (id)
);

ALTER TABLE public.evaluation
    OWNER TO ${user_owner};
