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
@Table(name = "payment_method")
public class PaymentMethod extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_method_id_sequence")
    @SequenceGenerator(name = "payment_method_id_sequence", sequenceName = "payment_method_id_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "method")
    @Convert(converter = PaymentMethodConverter.class)
    private com.example.coursemanagementapp.enums.PaymentMethod method;

    public static class PaymentMethodConverter extends GenericEnumConverter<com.example.coursemanagementapp.enums.PaymentMethod> {
        public PaymentMethodConverter() {
            super(com.example.coursemanagementapp.enums.PaymentMethod.class);
        }
    }

}
