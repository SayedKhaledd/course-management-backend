--liquibase formatted sql
--changeset sayed:20241031_refund_method_table
CREATE SEQUENCE public.refund_method_id_sequence
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807 CACHE 1;

ALTER SEQUENCE public.refund_method_id_sequence
    OWNER TO ${user_owner};

CREATE TABLE public.refund_method
(
    id                BIGINT                 NOT NULL DEFAULT nextval('refund_method_id_sequence'),
    method            VARCHAR(255)           NOT NULL,

    created_date      TIMESTAMP              NOT NULL,
    modified_date     TIMESTAMP              NOT NULL,
    created_by        CHARACTER VARYING(100) NOT NULL,
    modified_by       CHARACTER VARYING(100) NOT NULL,
    marked_as_deleted BOOLEAN                NOT NULL DEFAULT FALSE,
    CONSTRAINT refund_method_pk PRIMARY KEY (id),
    CONSTRAINT refund_method_method_uq UNIQUE (method)
) TABLESPACE pg_default;

ALTER TABLE public.refund_method
    OWNER TO ${user_owner};