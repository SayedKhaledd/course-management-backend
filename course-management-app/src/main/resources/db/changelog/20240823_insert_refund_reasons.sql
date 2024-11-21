--liquibase formatted sql
--changeset sayed:20240823_insert_refund_reasons
INSERT INTO public.refund_reason (id, reason, created_date, modified_date, created_by, modified_by, marked_as_deleted)
VALUES (nextval('refund_reason_id_sequence'), 'DID_NOT_LIKE_THE_COURSE', current_timestamp, current_timestamp, 'system',
        'system',
        false),
       (nextval('refund_reason_id_sequence'), 'DID_NOT_ATTEND', current_timestamp, current_timestamp, 'system',
        'system',
        false),
       (nextval('refund_reason_id_sequence'), 'Change Specaility', current_timestamp, current_timestamp, 'system',
        'system',
        false),
       (nextval('refund_reason_id_sequence'), 'Other', current_timestamp, current_timestamp, 'system', 'system',
        false);
--changeset sayed:20241117_change_refund_reasons
UPDATE public.refund_reason
    SET marked_as_deleted = true;
INSERT INTO public.refund_reason (id, reason, created_date, modified_date, created_by, modified_by, marked_as_deleted)
 VALUES (nextval('refund_reason_id_sequence'), 'أسباب شخصية', current_timestamp, current_timestamp, 'system', 'system', false),
        (nextval('refund_reason_id_sequence'), 'مش هيكمل في الزمالة', current_timestamp, current_timestamp, 'system', 'system', false),
        (nextval('refund_reason_id_sequence'), 'هيأجل حاليا', current_timestamp, current_timestamp, 'system', 'system', false),
        (nextval('refund_reason_id_sequence'), 'محتاج لايف والمواعيد مش مناسبة', current_timestamp, current_timestamp, 'system', 'system', false),
        (nextval('refund_reason_id_sequence'), 'خارج مصر - اسباب تقنية', current_timestamp, current_timestamp, 'system', 'system', false),
        (nextval('refund_reason_id_sequence'), 'معجبهوش الكورس', current_timestamp, current_timestamp, 'system', 'system', false),
        (nextval('refund_reason_id_sequence'), 'غير التخصص', current_timestamp, current_timestamp, 'system', 'system', false),
        (nextval('refund_reason_id_sequence'), 'أخرى', current_timestamp, current_timestamp, 'system', 'system', false);