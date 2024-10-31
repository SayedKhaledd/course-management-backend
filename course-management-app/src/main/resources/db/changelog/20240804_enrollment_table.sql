--liquibase formatted sql
--changeset sayed:20240804_enrollment_table
CREATE SEQUENCE public.enrollment_id_sequence
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807 CACHE 1;

ALTER SEQUENCE public.enrollment_id_sequence
    OWNER TO ${user_owner};

CREATE TABLE public.enrollment
(
    id                 BIGINT                 NOT NULL DEFAULT nextval('enrollment_id_sequence'),
    course_id          BIGINT                 NOT NULL,
    client_id          BIGINT                 NOT NULL,
    amount_paid        decimal,
    remaining_amount   decimal,
    currency           VARCHAR(255),
    discount           decimal,
    payment_status_id  bigint,
    payment_method_id  BIGINT,
    pay_in_installment BOOLEAN,
    review             TEXT,
    rate               decimal,
    referral_source_id BIGINT                 NOT NULL,
    action_taken_id    BIGINT,
    description        TEXT,
    inside_Egypt       BOOLEAN                NOT NULL DEFAULT TRUE,
    is_received        BOOLEAN                NOT NULL DEFAULT FALSE,


    created_date       TIMESTAMP              NOT NULL,
    modified_date      TIMESTAMP              NOT NULL,
    created_by         CHARACTER VARYING(100) NOT NULL,
    modified_by        CHARACTER VARYING(100) NOT NULL,
    marked_as_deleted  BOOLEAN                NOT NULL DEFAULT FALSE,
    CONSTRAINT enrollment_pk PRIMARY KEY (id),
    CONSTRAINT enrollment_course_id_fk FOREIGN KEY (course_id) REFERENCES public.course (id),
    CONSTRAINT enrollment_client_id_fk FOREIGN KEY (client_id) REFERENCES public.client (id),
    CONSTRAINT enrollment_referral_source_id_fk FOREIGN KEY (referral_source_id) REFERENCES public.referral_source (id),
    CONSTRAINT enrollment_action_taken_id_fk FOREIGN KEY (action_taken_id) REFERENCES public.action_taken (id),
    CONSTRAINT enrollment_payment_method_id_fk FOREIGN KEY (payment_method_id) REFERENCES public.payment_method (id),
    CONSTRAINT enrollment_payment_status_id_fk FOREIGN KEY (payment_status_id) REFERENCES public.payment_status (id)
) TABLESPACE pg_default;

ALTER TABLE public.enrollment
    OWNER TO ${user_owner};
CREATE UNIQUE INDEX enrollment_client_id_course_id_uq
    ON public.enrollment (course_id, client_id)
    WHERE marked_as_deleted = false;
--changeset sayed:20241031_add_total_amount_column_to_enrollment_table
ALTER TABLE public.enrollment
    ADD column total_amount decimal;
