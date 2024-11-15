--liquibase formatted sql
--changeset sayed:20241113_insert_initial_courses
INSERT INTO public.course (id, code, part, name, description, status_id, start_date, end_date, price, created_date,
                           modified_date, created_by, modified_by, marked_as_deleted)
VALUES (nextval('course_id_sequence'), 'N/A', '1', 'FRCR', null, '1', null, null, 0.0, current_timestamp,
        current_timestamp, 'system', 'system',
        false),
       (nextval('course_id_sequence'), 'N/A', '1', 'علاج طبيعي', null, '1', null, null, 0.0, current_timestamp,
        current_timestamp, 'system', 'system',
        false),
       (nextval('course_id_sequence'), 'N/A', '1', 'MFDS', null, '1', null, null, 0.0, current_timestamp,
        current_timestamp, 'system', 'system',
        false),
       (nextval('course_id_sequence'), 'N/A', '1', 'USMLE', null, '1', null, null, 0.0, current_timestamp,
        current_timestamp, 'system', 'system',
        false),
       (nextval('course_id_sequence'), 'N/A', '1', 'MRCPch', null, '1', null, null, 0.0, current_timestamp,
        current_timestamp, 'system', 'system',
        false),
       (nextval('course_id_sequence'), 'N/A', '1', 'FRCS/ICO', null, '1', null, null, 0.0, current_timestamp,
        current_timestamp, 'system', 'system',
        false),
       (nextval('course_id_sequence'), 'N/A', '1', 'INBDE', null, '1', null, null, 0.0, current_timestamp,
        current_timestamp, 'system', 'system',
        false),
       (nextval('course_id_sequence'), 'N/A', '1', 'Other أخرى', null, '1', null, null, 0.0, current_timestamp,
        current_timestamp, 'system', 'system',
        false),
       (nextval('course_id_sequence'), 'N/A', '1', 'MRCOG', null, '1', null, null, 0.0, current_timestamp,
        current_timestamp, 'system', 'system',
        false),
       (nextval('course_id_sequence'), 'N/A', '1', 'FRCA/EDAIC', null, '1', null, null, 0.0, current_timestamp,
        current_timestamp, 'system', 'system',
        false),
       (nextval('course_id_sequence'), 'N/A', '1', 'UKMLA', null, '1', null, null, 0.0, current_timestamp,
        current_timestamp, 'system', 'system',
        false),
       (nextval('course_id_sequence'), 'N/A', '1', 'طب بيطري', null, '1', null, null, 0.0, current_timestamp,
        current_timestamp, 'system', 'system',
        false),
       (nextval('course_id_sequence'), 'N/A', '1', 'MRCP', null, '1', null, null, 0.0, current_timestamp,
        current_timestamp, 'system', 'system',
        false),
       (nextval('course_id_sequence'), 'N/A', '1', 'تمريض', null, '1', null, null, 0.0, current_timestamp,
        current_timestamp, 'system', 'system',
        false),
       (nextval('course_id_sequence'), 'N/A', '1', 'MRCPath', null, '1', null, null, 0.0, current_timestamp,
        current_timestamp, 'system', 'system',
        false),
       (nextval('course_id_sequence'), 'N/A', '1', 'MCCQE', null, '1', null, null, 0.0, current_timestamp,
        current_timestamp, 'system', 'system',
        false),
       (nextval('course_id_sequence'), 'N/A', '1', 'Dermatology', null, '1', null, null, 0.0, current_timestamp,
        current_timestamp, 'system', 'system',
        false),
       (nextval('course_id_sequence'), 'N/A', '1', 'MRCEM', null, '1', null, null, 0.0, current_timestamp,
        current_timestamp, 'system', 'system',
        false),
       (nextval('course_id_sequence'), 'N/A', '1', 'Student', null, '1', null, null, 0.0, current_timestamp,
        current_timestamp, 'system', 'system',
        false),
       (nextval('course_id_sequence'), 'N/A', '1', 'Dentist', null, '1', null, null, 0.0, current_timestamp,
        current_timestamp, 'system', 'system',
        false),
       (nextval('course_id_sequence'), 'N/A', '1', 'Pharmacy', null, '1', null, null, 0.0, current_timestamp,
        current_timestamp, 'system', 'system',
        false),
       (nextval('course_id_sequence'), 'N/A', '1', 'MRCS', null, '1', null, null, 0.0, current_timestamp,
        current_timestamp, 'system', 'system',
        false),
       (nextval('course_id_sequence'), 'N/A', '1', 'MRCGP طب أسرة', null, '1', null, null, 0.0, current_timestamp,
        current_timestamp, 'system', 'system',
        false),
       (nextval('course_id_sequence'), 'N/A', '1', 'EDIC - ICU', null, '1', null, null, 0.0, current_timestamp,
        current_timestamp, 'system', 'system',
        false),
       (nextval('course_id_sequence'), 'N/A', '1', 'MRCPsych', null, '1', null, null, 0.0, current_timestamp,
        current_timestamp, 'system', 'system',
        false);