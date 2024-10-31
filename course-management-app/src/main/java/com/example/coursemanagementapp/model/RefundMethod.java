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
@Table(name = "refund_method")
public class RefundMethod extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "refund_method_id_sequence")
    @SequenceGenerator(name = "refund_method_id_sequence", sequenceName = "refund_method_id_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "method")
    @Convert(converter = RefundMethodConverter.class)
    private com.example.coursemanagementapp.enums.RefundMethod method;

    public static class RefundMethodConverter extends GenericEnumConverter<com.example.coursemanagementapp.enums.RefundMethod> {
        public RefundMethodConverter() {
            super(com.example.coursemanagementapp.enums.RefundMethod.class);
        }
    }

}
