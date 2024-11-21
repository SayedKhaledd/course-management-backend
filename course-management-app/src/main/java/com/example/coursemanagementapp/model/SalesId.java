package com.example.coursemanagementapp.model;

import com.example.coursemanagementapp.enums.PaymentType;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class SalesId implements Serializable {

    private Long entityId;

    private PaymentType type;
}
