package com.example.coursemanagementapp.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ClientStatus {
    FOLLOW_UP_CALL("متابعة مكالمة"),
    INTERESTED("مهتم"),
    DID_NOT_LIKE_THE_COURSE("معجبوش الكورس"),
    COURSE_RESERVED("حجز الكورس"),
    NEXT_COURSE("الكورس التالي"),
    FELLOWSHIP_ENDED("خلص الزمالة"),
    MESSAGE_FOLLOW_UP("متابعة رسائل"),
    WRONG_NUMBER("الرقم غير صحيح"),
    COURSE_EXPENSIVE("الكورس غالى"),
    INTRODUCTORY("التعريفية"),
    NOT_INTERESTED("غير مهتم"),
    SUBSCRIBED_TO_ANOTHER_COURSE("اشترك في كورس اخر"),
    OTHER("أخرى أذكرها");
    private final String status;

    @JsonValue
    @Override
    public String toString() {
        return status;
    }
}
