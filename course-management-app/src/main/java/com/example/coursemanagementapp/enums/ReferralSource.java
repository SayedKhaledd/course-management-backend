package com.example.coursemanagementapp.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ReferralSource {
    SOCIAL_MEDIA("SOCIAL_MEDIA"),
    RECOMMENDATION("RECOMMENDATION"),
    WEBSITE("WEBSITE"),
    OTHER("OTHER");
    private final String source;
}
