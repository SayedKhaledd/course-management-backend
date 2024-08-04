--liquibase formatted sql
--changeset sayed:20240726_referral_source_table
CREATE SEQUENCE public.referral_source_id_sequence
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807 CACHE 1;

ALTER SEQUENCE public.referral_source_id_sequence
    OWNER TO ${user_owner};

CREATE TABLE public.referral_source
(
    id                BIGINT                 NOT NULL DEFAULT nextval('referral_source_id_sequence'),
    source            VARCHAR(255)           NOT NULL,

    created_date      TIMESTAMP              NOT NULL,
    modified_date     TIMESTAMP              NOT NULL,
    created_by        CHARACTER VARYING(100) NOT NULL,
    modified_by       CHARACTER VARYING(100) NOT NULL,
    marked_as_deleted BOOLEAN                NOT NULL DEFAULT FALSE,
    CONSTRAINT referral_source_pk PRIMARY KEY (id),
    CONSTRAINT referral_source_source_uq UNIQUE (source)
);

ALTER TABLE public.referral_source
    OWNER TO ${user_owner};
