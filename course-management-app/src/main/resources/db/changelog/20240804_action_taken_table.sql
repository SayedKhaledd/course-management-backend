--liquibase formatted sql
--changeset sayed:20240804_action_taken_table
CREATE SEQUENCE public.action_taken_id_sequence
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807 CACHE 1;

ALTER SEQUENCE public.action_taken_id_sequence
    OWNER TO ${user_owner};

CREATE TABLE public.action_taken
(
    id                BIGINT                 NOT NULL DEFAULT nextval('action_taken_id_sequence'),
    action            VARCHAR(255)           NOT NULL,

    created_date      TIMESTAMP              NOT NULL,
    modified_date     TIMESTAMP              NOT NULL,
    created_by        CHARACTER VARYING(100) NOT NULL,
    modified_by       CHARACTER VARYING(100) NOT NULL,
    marked_as_deleted BOOLEAN                NOT NULL DEFAULT FALSE,
    CONSTRAINT action_taken_pk PRIMARY KEY (id),
    CONSTRAINT action_taken_action_uq UNIQUE (action)
)TABLESPACE pg_default;

ALTER TABLE public.action_taken
    OWNER TO ${user_owner};
