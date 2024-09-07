--liquibase formatted sql
--changeset sayed:20240823_insert_referral_sources
INSERT INTO public.referral_source (id, source, created_date, modified_date, created_by, modified_by, marked_as_deleted)
VALUES (nextval('referral_source_id_sequence'), 'SOCIAL_MEDIA', current_timestamp, current_timestamp, 'system',
        'system',
        false),
       (nextval('referral_source_id_sequence'), 'RECOMMENDATION', current_timestamp, current_timestamp, 'system',
        'system',
        false),
       (nextval('referral_source_id_sequence'), 'WEBSITE', current_timestamp, current_timestamp, 'system',
        'system',
        false),
       (nextval('referral_source_id_sequence'), 'OTHER', current_timestamp, current_timestamp, 'system', 'system',
        false);