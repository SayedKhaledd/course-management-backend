--liquibase formatted sql
--changeset sayed:20240823_insert_payment_methods
INSERT INTO public.payment_method (id, method, created_date, modified_date, created_by, modified_by, marked_as_deleted)
VALUES (nextval('payment_method_id_sequence'), 'CASH', current_timestamp, current_timestamp, 'system', 'system', false),
       (nextval('payment_method_id_sequence'), 'CARD', current_timestamp, current_timestamp, 'system', 'system', false),
       (nextval('payment_method_id_sequence'), 'THIRD_PARTY', current_timestamp, current_timestamp, 'system', 'system',
        false);