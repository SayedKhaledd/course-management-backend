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
@Table(name = "refund_status")
public class RefundStatus extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "refund_status_id_sequence")
    @SequenceGenerator(name = "refund_status_id_sequence", sequenceName = "refund_status_id_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "status")
    @Convert(converter = RefundStatusConverter.class)
    private com.example.coursemanagementapp.enums.RefundStatus status;

    public static class RefundStatusConverter extends GenericEnumConverter<com.example.coursemanagementapp.enums.RefundStatus> {
        public RefundStatusConverter() {
            super(com.example.coursemanagementapp.enums.RefundStatus.class);
        }
    }

}
