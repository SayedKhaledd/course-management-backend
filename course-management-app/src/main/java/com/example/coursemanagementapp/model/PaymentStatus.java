package com.example.coursemanagementapp.model;

import com.example.backendcoreservice.model.AbstractEntity;
import com.example.coursemanagementapp.enums.GenericEnumConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "payment_status")
public class PaymentStatus extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_status_id_sequence")
    @SequenceGenerator(name = "payment_status_id_sequence", sequenceName = "payment_status_id_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "status")
    @Convert(converter = PaymentStatusConverter.class)
    private com.example.coursemanagementapp.enums.PaymentStatus status;

    public static class PaymentStatusConverter extends GenericEnumConverter<com.example.coursemanagementapp.enums.PaymentStatus> {
        public PaymentStatusConverter() {
            super(com.example.coursemanagementapp.enums.PaymentStatus.class);
        }
    }

}
