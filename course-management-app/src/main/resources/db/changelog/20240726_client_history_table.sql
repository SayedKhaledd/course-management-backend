--liquibase formatted sql
--changeset sayed:20240726_client_history_table
CREATE SEQUENCE public.client_history_id_sequence
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807 CACHE 1;

ALTER SEQUENCE public.client_history_id_sequence
    OWNER TO ${user_owner};

CREATE TABLE public.client_history
(
    id                BIGINT                 NOT NULL DEFAULT nextval('client_history_id_sequence'),
    field_name        VARCHAR(255)           NOT NULL,
    old_value         VARCHAR(255),
    new_value         VARCHAR(255),
    client_id         BIGINT,


    created_date      TIMESTAMP              NOT NULL,
    modified_date     TIMESTAMP              NOT NULL,
    created_by        CHARACTER VARYING(100) NOT NULL,
    modified_by       CHARACTER VARYING(100) NOT NULL,
    marked_as_deleted BOOLEAN                NOT NULL DEFAULT FALSE,
    CONSTRAINT client_history_pk PRIMARY KEY (id)

) TABLESPACE pg_default;

ALTER TABLE public.client_history
    OWNER TO ${user_owner};
