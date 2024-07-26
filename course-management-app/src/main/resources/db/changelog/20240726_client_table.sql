--liquibase formatted sql
--changeset sayed:20240726_client_table
CREATE SEQUENCE public.client_id_sequence
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807 CACHE 1;

ALTER SEQUENCE public.client_id_sequence
    OWNER TO ${user.owner};

CREATE TABLE public.client
(
    id                       BIGINT                 NOT NULL DEFAULT nextval('client_id_sequence'),
    first_name               VARCHAR(255)           NOT NULL,
    last_name                VARCHAR(255)           NOT NULL,
    email                    VARCHAR(255)           NOT NULL,
    phone_number             VARCHAR(255)           NOT NULL,
    alternative_phone_number VARCHAR(255),
    address                  VARCHAR(255),
    country                  VARCHAR(255),
    nationality              VARCHAR(255),


    created_date             TIMESTAMP              NOT NULL,
    modified_date            TIMESTAMP              NOT NULL,
    created_by               CHARACTER VARYING(100) NOT NULL,
    modified_by              CHARACTER VARYING(100) NOT NULL,
    marked_as_deleted        BOOLEAN                NOT NULL DEFAULT FALSE,
    CONSTRAINT referral_source_pk PRIMARY KEY (id),
    CONSTRAINT referral_source_source_unique UNIQUE (source)
);

ALTER TABLE public.client
    OWNER TO ${user.owner};
