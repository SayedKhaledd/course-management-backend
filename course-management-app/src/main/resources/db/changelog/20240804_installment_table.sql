--liquibase formatted sql
--changeset sayed:20240804_installment_table
CREATE SEQUENCE public.installment_id_sequence
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807 CACHE 1;

ALTER SEQUENCE public.installment_id_sequence
    OWNER TO ${user_owner};

CREATE TABLE public.installment
(
    id                BIGINT                 NOT NULL DEFAULT nextval('installment_id_sequence'),
    enrollment_id     BIGINT                 NOT NULL,
    amount            DECIMAL                NOT NULL,
    payment_due_date  TIMESTAMP              NOT NULL,
    payment_date      TIMESTAMP,
    payment_method_id BIGINT,
    payment_status_id BIGINT,
    currency          CHARACTER VARYING(3)    ,


    created_date      TIMESTAMP              NOT NULL,
    modified_date     TIMESTAMP              NOT NULL,
    created_by        CHARACTER VARYING(100) NOT NULL,
    modified_by       CHARACTER VARYING(100) NOT NULL,
    marked_as_deleted BOOLEAN                NOT NULL DEFAULT FALSE,
    CONSTRAINT installment_pk PRIMARY KEY (id),
    CONSTRAINT installment_enrollment_id_fk FOREIGN KEY (enrollment_id) REFERENCES public.enrollment (id),
    CONSTRAINT installment_payment_method_id_fk FOREIGN KEY (payment_method_id) REFERENCES public.payment_method (id),
    CONSTRAINT installment_payment_status_id_fk FOREIGN KEY (payment_status_id) REFERENCES public.payment_status (id)

) TABLESPACE pg_default;

ALTER TABLE public.installment
    OWNER TO ${user_owner};
