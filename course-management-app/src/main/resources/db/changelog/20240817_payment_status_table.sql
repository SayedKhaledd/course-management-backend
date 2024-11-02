--liquibase formatted sql
--changeset sayed:20240817_payment_status_table
CREATE SEQUENCE public.payment_status_id_sequence
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807 CACHE 1;

ALTER SEQUENCE public.payment_status_id_sequence
    OWNER TO ${user_owner};

CREATE TABLE IF NOT EXISTS public.payment_status
(
    id                BIGINT                 NOT NULL DEFAULT nextval('payment_status_id_sequence'),
    status            VARCHAR(255)           NOT NULL,


    created_date      TIMESTAMP              NOT NULL,
    modified_date     TIMESTAMP              NOT NULL,
    created_by        CHARACTER VARYING(100) NOT NULL,
    modified_by       CHARACTER VARYING(100) NOT NULL,
    marked_as_deleted BOOLEAN                NOT NULL DEFAULT FALSE,
    CONSTRAINT payment_status_pk PRIMARY KEY (id),
    CONSTRAINT payment_status_status_uq UNIQUE (status)


) TABLESPACE pg_default;

ALTER TABLE public.payment_status
    OWNER TO ${user_owner};
