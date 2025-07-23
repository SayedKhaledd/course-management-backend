package com.example.coursemanagementapp.validation;

import com.example.coursemanagementapp.dto.ParsedClient;

import java.util.List;

public interface ValidationHandler {

    void validate(List<ParsedClient> parsedClients);

    static <T> String getDefaultBeanName(Class<T> type) {
        String simpleName = type.getSimpleName();
        return Character.toLowerCase(simpleName.charAt(0)) + simpleName.substring(1);
    }
}
