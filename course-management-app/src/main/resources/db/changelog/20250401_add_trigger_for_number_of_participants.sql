--liquibase formatted sql
--changeset sayed:20250401_add_trigger_for_number_of_participants splitStatements:false
CREATE FUNCTION update_number_of_participants()
    RETURNS TRIGGER
    LANGUAGE plpgsql
AS
$_$
DECLARE
    enrolled_action_id BIGINT;
BEGIN
    -- Get the action ID for 'ENROLLED'
    SELECT id
    INTO enrolled_action_id
    FROM public.action_taken
    WHERE action = 'ENROLLED';

    IF TG_OP = 'INSERT' THEN
        IF NEW.marked_as_deleted = false AND NEW.action_taken_id = enrolled_action_id THEN
            UPDATE public.course
            SET number_of_participants = number_of_participants + 1
            WHERE id = NEW.course_id;
        END IF;

    ELSIF TG_OP = 'DELETE' THEN
        IF OLD.marked_as_deleted = false AND OLD.action_taken_id = enrolled_action_id THEN
            UPDATE public.course
            SET number_of_participants = number_of_participants - 1
            WHERE id = OLD.course_id;
        END IF;

    ELSIF TG_OP = 'UPDATE' THEN
        -- Case: ENROLLED removed (either deleted or action changed)
        IF OLD.marked_as_deleted = false AND OLD.action_taken_id = enrolled_action_id AND
           (NEW.marked_as_deleted = true OR NEW.action_taken_id != enrolled_action_id OR
            OLD.course_id != NEW.course_id) THEN
            UPDATE public.course
            SET number_of_participants = number_of_participants - 1
            WHERE id = OLD.course_id;
        END IF;

        -- Case: ENROLLED added (either undeleted or new action)
        IF NEW.marked_as_deleted = false AND NEW.action_taken_id = enrolled_action_id AND
           (OLD.marked_as_deleted = true OR OLD.action_taken_id != enrolled_action_id OR
            OLD.course_id != NEW.course_id) THEN
            UPDATE public.course
            SET number_of_participants = number_of_participants + 1
            WHERE id = NEW.course_id;
        END IF;
    END IF;

    RETURN null;

end;
$_$;
CREATE TRIGGER enrollment_participant_count_trigger
    AFTER INSERT OR DELETE OR UPDATE
    ON public.enrollment
    FOR EACH ROW
    EXECUTE FUNCTION update_number_of_participants();