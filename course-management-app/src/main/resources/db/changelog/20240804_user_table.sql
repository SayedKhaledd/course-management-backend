--liquibase formatted sql
--changeset sayed:20240804_user_table
CREATE SEQUENCE public.user_id_sequence
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807 CACHE 1;

ALTER SEQUENCE public.user_id_sequence
    OWNER TO ${user_owner};

CREATE TABLE IF NOT EXISTS public.user
(
    id                BIGINT                 NOT NULL DEFAULT nextval('user_id_sequence'),
    name              VARCHAR(255)           NOT NULL,
    email             VARCHAR(255)           NOT NULL,
    phone_number      VARCHAR(255)           NOT NULL,


    created_date      TIMESTAMP              NOT NULL,
    modified_date     TIMESTAMP              NOT NULL,
    created_by        CHARACTER VARYING(100) NOT NULL,
    modified_by       CHARACTER VARYING(100) NOT NULL,
    marked_as_deleted BOOLEAN                NOT NULL DEFAULT FALSE,
    CONSTRAINT user_pk PRIMARY KEY (id),
    CONSTRAINT user_email_uq UNIQUE (email),
    CONSTRAINT user_phone_number_uq UNIQUE (phone_number)

) TABLESPACE pg_default;

ALTER TABLE public.user
    OWNER TO ${user_owner};