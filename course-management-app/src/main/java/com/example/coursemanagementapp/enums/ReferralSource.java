package com.example.coursemanagementapp.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ReferralSource {
    FB_PAID("FB Paid"),
    FB_ORGANIC("FB organic"),
    GOOGLE("Google"),
    WEBSITE("Website"),
    YOUTUBE("Youtube"),
    TELEGRAM("Telegram"),
    REGISTRATION("registration"),
    FRIEND("Friend"),
    EMAIL("Email"),
    SMS("SMS"),
    INSTAGRAM("Instagram"),
    CONFERENCE("Confrance"),
    WHATSAPP_CAMPAIGN("WhatsAPP Campign"),
    B_TO_B("B t B"),
    ENROLLED_PREVIOUSLY("مشترك سابق");

    private final String source;

    @JsonValue
    @Override
    public String toString() {
        return source;
    }
}
