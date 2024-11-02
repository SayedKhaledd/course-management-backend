package com.example.coursemanagementapp.enums;

import jakarta.persistence.AttributeConverter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GenericEnumConverter<E extends Enum<E>> implements AttributeConverter<E, String> {

    private final Class<E> enumType;

    public GenericEnumConverter(Class<E> enumType) {
        this.enumType = enumType;
    }

    @Override
    public String convertToDatabaseColumn(E attribute) {
        return attribute != null ? attribute.toString() : null;
    }

    @Override
    public E convertToEntityAttribute(String dbData) {
        for (E enumConstant : enumType.getEnumConstants()) {
            if (enumConstant.toString().equals(dbData)) {
                return enumConstant;
            }
        }
        throw new IllegalArgumentException("Unknown database value: " + dbData);
    }
}

