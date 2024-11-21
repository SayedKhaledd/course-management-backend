package com.example.coursemanagementapp.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RefundReason {

    PERSONAL_REASONS("أسباب شخصية"),
    NOT_INTERESTED("مش هيكمل في الزمالة"),
    POSTPONED("هيأجل حاليا"),
    NEEDS_LIVE("محتاج لايف والمواعيد مش مناسبة"),
    OUTSIDE_EGYPT("خارج مصر - اسباب تقنية"),
    NOT_LIKED("معجبهوش الكورس"),
    NOT_SPECIALIZED("غير التخصص"),
    OTHER("أخرى");



    private final String reason;

    @JsonValue
    @Override
    public String toString() {
        return reason;
    }
}
