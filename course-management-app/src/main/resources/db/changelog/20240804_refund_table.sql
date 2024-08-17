--liquibase formatted sql
--changeset sayed:20240804_refund_table
CREATE SEQUENCE public.refund_id_sequence
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807 CACHE 1;

ALTER SEQUENCE public.refund_id_sequence
    OWNER TO ${user_owner};

CREATE TABLE public.refund
(
    id                BIGINT                 NOT NULL DEFAULT nextval('refund_id_sequence'),
    enrollment_id     BIGINT                 NOT NULL,
    amount            DECIMAL                NOT NULL,
    payment_method_id BIGINT,
    refund_date       TIMESTAMP              NOT NULL,
    refund_reason_id  BIGINT                 NOT NULL,
    payment_status    CHARACTER VARYING(255),
    explanation       CHARACTER VARYING(255),
    is_confirmed      BOOLEAN                NOT NULL DEFAULT FALSE,


    created_date      TIMESTAMP              NOT NULL,
    modified_date     TIMESTAMP              NOT NULL,
    created_by        CHARACTER VARYING(100) NOT NULL,
    modified_by       CHARACTER VARYING(100) NOT NULL,
    marked_as_deleted BOOLEAN                NOT NULL DEFAULT FALSE,
    CONSTRAINT refund_pk PRIMARY KEY (id),
    CONSTRAINT refund_enrollment_id_fk FOREIGN KEY (enrollment_id) REFERENCES public.enrollment (id),
    CONSTRAINT refund_payment_method_id_fk FOREIGN KEY (payment_method_id) REFERENCES public.payment_method (id),
    CONSTRAINT refund_refund_reason_id_fk FOREIGN KEY (refund_reason_id) REFERENCES public.refund_reason (id),
    CONSTRAINT refund_status_fk FOREIGN KEY (payment_status) REFERENCES public.payment_status (status)

) TABLESPACE pg_default;

ALTER TABLE public.refund
    OWNER TO ${user_owner};
