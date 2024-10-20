package com.example.coursemanagementapp.model;

import com.example.backendcoreservice.model.AbstractEntity;
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
@Table(name = "refund_history")
public class RefundHistory extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "refund_history_id_sequence")
    @SequenceGenerator(name = "refund_history_id_sequence", sequenceName = "refund_history_id_sequence", allocationSize = 1)
    private Long id;

    @JoinColumn(name = "refund_id", updatable = false)
    @ManyToOne
    private Refund refund;

    @Column(name = "refund_id", insertable = false, updatable = false)
    private Long refundId;

    @Column(name = "field_name", nullable = false)
    private String fieldName;

    @Column(name = "old_value")
    private String oldValue;

    @Column(name = "new_value")
    private String newValue;

}
