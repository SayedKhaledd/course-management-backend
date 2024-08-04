--liquibase formatted sql
--changeset sayed:20240804_refund_reason_table
CREATE SEQUENCE public.refund_reason_id_sequence
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807 CACHE 1;

ALTER SEQUENCE public.refund_reason_id_sequence
    OWNER TO ${user_owner};

CREATE TABLE IF NOT EXISTS public.refund_reason
(
    id                BIGINT                 NOT NULL DEFAULT nextval('refund_reason_id_sequence'),
    reason            VARCHAR(255)           NOT NULL,


    created_date      TIMESTAMP              NOT NULL,
    modified_date     TIMESTAMP              NOT NULL,
    created_by        CHARACTER VARYING(100) NOT NULL,
    modified_by       CHARACTER VARYING(100) NOT NULL,
    marked_as_deleted BOOLEAN                NOT NULL DEFAULT FALSE,
    CONSTRAINT refund_reason_pk PRIMARY KEY (id),
    CONSTRAINT refund_reason_reason_uq UNIQUE (reason)


);

ALTER TABLE public.refund_reason
    OWNER TO ${user_owner};
