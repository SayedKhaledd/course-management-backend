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
@Table(name = "refund_reason")
public class RefundReason extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "refund_reason_id_sequence")
    @SequenceGenerator(name = "refund_reason_id_sequence", sequenceName = "refund_reason_id_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "reason")
    @Convert(converter = RefundReasonConverter.class)
    private com.example.coursemanagementapp.enums.RefundReason reason;

    public static class RefundReasonConverter extends GenericEnumConverter<com.example.coursemanagementapp.enums.RefundReason> {
        public RefundReasonConverter() {
            super(com.example.coursemanagementapp.enums.RefundReason.class);
        }
    }
}
