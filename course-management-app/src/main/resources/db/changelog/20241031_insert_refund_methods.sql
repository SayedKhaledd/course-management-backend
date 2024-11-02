--liquibase formatted sql
--changeset sayed:20241031_insert_refund_methods
INSERT INTO public.refund_method (id, method, created_date, modified_date, created_by, modified_by, marked_as_deleted)
VALUES (nextval('refund_method_id_sequence'), 'Cash', current_timestamp, current_timestamp, 'system', 'system', false),
       (nextval('refund_method_id_sequence'), 'Bank Deposit', current_timestamp, current_timestamp, 'system', 'system',
        false),
       (nextval('refund_method_id_sequence'), 'Vodafone', current_timestamp, current_timestamp, 'system', 'system',
        false),
       (nextval('refund_method_id_sequence'), 'Stripe', current_timestamp, current_timestamp, 'system', 'system',
        false),
       (nextval('refund_method_id_sequence'), 'Bank transfer', current_timestamp, current_timestamp, 'system', 'system',
        false);